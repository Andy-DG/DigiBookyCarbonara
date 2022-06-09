package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.Name;
import com.carbonaracode.digibookycarbonara.books.Author;
import com.carbonaracode.digibookycarbonara.books.Book;
import com.carbonaracode.digibookycarbonara.books.BookRepository;
import com.carbonaracode.digibookycarbonara.members.Address;
import com.carbonaracode.digibookycarbonara.members.Member;
import com.carbonaracode.digibookycarbonara.members.MemberRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LendingRepositoryTest {
    @Test
    void givenABookAndAMember_whenMemberBorrowsBook_thenBookIsInLentList() {
        //Given
        Member member = Member.newBuilder()
                .withInss("666")
                .withName(new Name("Pablo", "Ijscobar"))
                .withEmail("boergor@king.nl")
                .withAddress(new Address("snowstreet", 1, 1, "OkayCity"))
                .build();

        Book book = Book.newBuilder()
                .withIsbn("978-1-4028-9462-6")
                .withTitle("The Phoenix Project")
                .withAuthor(new Author("Gene", "Kim"))
                .withSummary("Bill is an IT manager at Parts Unlimited. " +
                        "It's Tuesday morning and on his drive into the office, Bill gets a call from the CEO.\n" +
                        "\n" +
                        "The company's new IT initiative, code named Phoenix Project, is critical to the future of Parts Unlimited, " +
                        "but the project is massively over budget and very late. " +
                        "The CEO wants Bill to report directly to him and fix the mess in ninety days " +
                        "or else Bill's entire department will be outsourced.\n")
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
        Map<Member, List<LentBook>> lendingMap = lendingRepository.getLendingMap();
        List<LentBook> lentBooks = lendingMap.get(member);
        boolean contains = lentBooks.contains(lentBook);

        assertTrue(contains);
    }
}
