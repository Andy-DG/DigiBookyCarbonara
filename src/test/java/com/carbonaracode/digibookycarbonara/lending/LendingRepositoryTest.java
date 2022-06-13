package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.Name;
import com.carbonaracode.digibookycarbonara.books.Author;
import com.carbonaracode.digibookycarbonara.books.Book;
import com.carbonaracode.digibookycarbonara.books.BookRepository;
import com.carbonaracode.digibookycarbonara.members.Address;
import com.carbonaracode.digibookycarbonara.members.Member;
import com.carbonaracode.digibookycarbonara.members.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LendingRepositoryTest {
    @Test
    void givenABookAndAMember_whenMemberBorrowsBook_thenBookIsInLentListOfMember() {
        //Given
        String isbn = UUID.randomUUID().toString();
        Member member = Member.newBuilder()
                .withInss("666")
                .withName(new Name("Pablo", "Ijscobar"))
                .withEmail("boergor@king.nl")
                .withAddress(new Address("snowstreet", 1, 1, "OkayCity"))
                .build();

        Book book = Book.newBuilder()
                .withIsbn(isbn)
                .withTitle("The Phoenix Project")
                .withAuthor(new Author("Gene", "Kim"))
                .withSummary("Summary")
                .build();

        MemberRepository memberRepository = new MemberRepository();
        memberRepository.register(member);
        BookRepository bookRepository = new BookRepository();
        bookRepository.addBook(book);
        LendingRepository lendingRepository = new LendingRepository();

        LendingSystem lendingSystem = new LendingSystem(memberRepository, bookRepository, lendingRepository);

        //When
        LentBook lentBook = lendingSystem.lend(book.getIsbn(), member.getInss());

        //Then
        Map<String, LentBook> lendingMap = lendingRepository.getLendingMap();
        List<LentBook> lentBooks = member.getLentBookList();


        assertTrue(lentBooks.contains(lentBook));
    }

    @Test
    @DisplayName("Given a lending repository, when we want to see all lent books for a member, we get a list of all books the member lent")
    void givenALendingRepositoryWhenWeWantToSeeAllLentBooksForAMemberWeGetAListOfAllBooksTheMemberLent() {
        //Given
        String isbn = UUID.randomUUID().toString();
        Book book = Book.newBuilder()
                .withIsbn(isbn)
                .withTitle("The Phoenix Project")
                .withAuthor(new Author("Gene", "Kim"))
                .withSummary("Summary")
                .build();
        Member member = Member.newBuilder()
                .withInss("666")
                .withName(new Name("Pablo", "Ijscobar"))
                .withEmail("boergor@king.nl")
                .withAddress(new Address("snowstreet", 1, 1, "OkayCity"))
                .build();
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.register(member);
        BookRepository bookRepository = new BookRepository();
        bookRepository.addBook(book);
        LendingRepository lendingRepository = new LendingRepository();

        LendingSystem lendingSystem = new LendingSystem(memberRepository, bookRepository, lendingRepository);
        lendingSystem.lend(book.getIsbn(), member.getInss());

        //When
        List<LentBook> actual = member.getLentBookList();

        //Then
        List<LentBook> expected = List.of(new LentBook(Book.newBuilder(book), lendingSystem.calculateLendingId(book.getIsbn(), member.getInss())));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given a lending repository, when we ask for a book list of a member that has no books, return an empty list.")
    void givenALendingRepositoryWhenWeAskForABookListOfAMemberThatHasNoBooksReturnAnEmptyList() {
        Member member = Member.newBuilder()
                .withInss("666")
                .withName(new Name("Pablo", "Ijscobar"))
                .withEmail("boergor@king.nl")
                .withAddress(new Address("snowstreet", 1, 1, "OkayCity"))
                .build();
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.register(member);
        BookRepository bookRepository = new BookRepository();
        LendingRepository lendingRepository = new LendingRepository();

        LendingSystem lendingSystem = new LendingSystem(memberRepository, bookRepository, lendingRepository);

        //When
        List<LentBook> actual = member.getLentBookList();

        //Then
        List<LentBook> expected = new ArrayList<>();

        assertEquals(expected, actual);
    }
}
