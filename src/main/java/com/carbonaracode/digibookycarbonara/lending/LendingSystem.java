package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.Book;
import com.carbonaracode.digibookycarbonara.books.BookRepository;
import com.carbonaracode.digibookycarbonara.books.LentBook;
import com.carbonaracode.digibookycarbonara.members.Member;
import com.carbonaracode.digibookycarbonara.members.MemberRepository;

public class LendingSystem {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private LendingRepository lendingRepository;
    public void lend(String isbn, String inss) {
        Book book = bookRepository.getBookMap().get(isbn);
        Member member = memberRepository.getMemberMap().get(inss);
        LentBook lentBook = new LentBook(Book.newBuilder()
                .withTitle(book.getTitle())
                .withAuthor(book.getAuthor())
                .withIsbn(book.getIsbn())
                .withSummary(book.getSummary()));
        lendingRepository.getLendingList().add(lentBook);


    }
}
