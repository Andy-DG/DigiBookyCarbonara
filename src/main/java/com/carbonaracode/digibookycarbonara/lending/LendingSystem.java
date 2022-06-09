package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.Book;
import com.carbonaracode.digibookycarbonara.books.BookRepository;
import com.carbonaracode.digibookycarbonara.members.Member;
import com.carbonaracode.digibookycarbonara.members.MemberRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
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
        bookAvailabilityCheck(book);
        Member member = memberRepository.getMemberByInss(inss);
        LentBook lentBook = new LentBook(Book.newBuilder(book), calculateLendingId(isbn, inss));
        return lendingRepository.addLentBook(member, lentBook);
    }

    private void bookAvailabilityCheck(Book book) throws IllegalArgumentException {
        if (lendingRepository.isLent(book)) throw new IllegalArgumentException("Book is already lent");
    }

    public String calculateLendingId(String isbn, String inss) {
        return isbn + inss + LocalDate.now();
    }

    public String returnBook(String lendingID, Member member, LocalDate returnTime) {
        LentBook bookToReturn = lendingRepository.getLendingMap().get(member).stream()
                .filter(lentBook -> lentBook.getLendingID().equals(lendingID)).toList().get(0);
        LocalDate dueDate = bookToReturn.getDueDate();
        lendingRepository.getLendingMap().get(member).remove(bookToReturn);
        if (dueDate.isAfter(returnTime)) {
            return "Book returned successfully!";
        }
        return "Book returned too late!";
    }
}
