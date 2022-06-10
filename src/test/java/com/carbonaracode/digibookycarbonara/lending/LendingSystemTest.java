package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.Name;
import com.carbonaracode.digibookycarbonara.books.Author;
import com.carbonaracode.digibookycarbonara.books.Book;
import com.carbonaracode.digibookycarbonara.books.BookRepository;
import com.carbonaracode.digibookycarbonara.members.Address;
import com.carbonaracode.digibookycarbonara.members.Member;
import com.carbonaracode.digibookycarbonara.members.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

class LendingSystemTest {
    @Test
    @DisplayName("Given a lending system, when we lend a book and it is available, then we get a lent book of the book")
    void givenALendingSystemWhenWeLendABookAndItIsAvailableThenWeGetALentBookOfTheBook() {
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
        LentBook expected = new LentBook(Book.newBuilder(book), isbn + "$666$" + LocalDate.now().toString());
        LentBook actual = lendingSystem.lend(book.getIsbn(), member.getInss());

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given a lending system, when we lend a book and it is not available, then throw an exception")
    void givenALendingSystemWhenWeLendABookAndItIsNotAvailableThenWeThrowAnException() {
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

        LentBook expected = new LentBook(LentBook.newBuilder(), isbn + "666" + LocalDate.now().toString());
        LentBook firstLent = lendingSystem.lend(book.getIsbn(), member.getInss());

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> lendingSystem.lend(book.getIsbn(), member.getInss()));
    }

    @Test
    void givenALentBookAndAUser_whenUserReturnsBook_thenLendingKeyIsNoLongerInLendingMap() {
        //Given
        String isbn = "7777";
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

        LentBook bookToReturn = lendingSystem.lend(isbn, member.getInss());
        String lendingID = bookToReturn.getLendingID();


        //When

        lendingSystem.returnBook(lendingID,LocalDate.now());

        //Then
        Assertions.assertFalse(lendingRepository.getLendingMap().containsKey(lendingSystem.calculateLendingId(isbn, member.getInss())));

    }

    @Test
    void givenALentBookAndUser_whenUserReturnsBookAfterDueDate_thenReturnMessageBookOverDue() {
        //Given
        String isbn = "7777";
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

        String lendingID = lendingSystem.lend(isbn, member.getInss()).getLendingID();
        //When
        LocalDate returnTime = LocalDate.now().plusWeeks(4);
        LentBook bookToReturn = lendingRepository.getLendingMap().get(lendingID);
        boolean actual = lendingSystem.isReturnedOnTime(bookToReturn, returnTime);

        //Then
        Assertions.assertFalse(actual);

    }

}
