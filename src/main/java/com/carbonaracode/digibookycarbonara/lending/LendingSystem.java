package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.Book;
import com.carbonaracode.digibookycarbonara.books.BookRepository;
import com.carbonaracode.digibookycarbonara.members.Member;
import com.carbonaracode.digibookycarbonara.members.MemberRepository;

public class LendingSystem {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private LendingRepository lendingRepository;

    public LendingSystem(MemberRepository memberRepository, BookRepository bookRepository, LendingRepository lendingRepository) {
        this.lendingRepository = lendingRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public LentBook lend(String isbn, String inss) {
        Book book = bookRepository.getBookByIsbn(isbn);
        Member member = memberRepository.getMemberByInss(inss);

        LentBook lentBook = new LentBook(Book.newBuilder(book));

        return lendingRepository.addLentBook(member, lentBook);
    }
}
