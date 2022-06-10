package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.Book;
import com.carbonaracode.digibookycarbonara.books.BookRepository;
import com.carbonaracode.digibookycarbonara.members.Member;
import com.carbonaracode.digibookycarbonara.members.MemberRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class LendingSystem {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private static final String DEFAULT_LENDING_ID_SPLITTER = "$";

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
        member.addLentBook(lentBook);
        return lendingRepository.addLentBook(lentBook.getLendingID(), lentBook);
    }

    private void bookAvailabilityCheck(Book book) throws IllegalArgumentException {
        if (lendingRepository.isLent(book)) throw new IllegalArgumentException("Book is already lent");
    }

    public String calculateLendingId(String isbn, String inss) {
        return isbn + DEFAULT_LENDING_ID_SPLITTER + inss + DEFAULT_LENDING_ID_SPLITTER + LocalDate.now();
    }

    public void returnBook(String lendingID, LocalDate returnTime) {
        LentBook bookToReturn = lendingRepository.getLendingMap().get(lendingID);
        lendingRepository.returnBook(lendingID);

        if (isReturnedOnTime(bookToReturn, returnTime)) {
            logger.info("Book returned successfully!");
        }
        logger.info("Book returned too late!");
    }

    public boolean isReturnedOnTime(LentBook bookToReturn, LocalDate returnTime) {
        return bookToReturn.getDueDate().isAfter(returnTime);
    }

    public void returnBook(String lendingID) {
        LentBook bookToReturn = lendingRepository.getLendingMap().get(lendingID);
        Member lendingMember = memberRepository.getMemberByInss(getInssFromLendingId(lendingID));
        lendingMember.returnLentBook(bookToReturn);
        lendingRepository.returnBook(lendingID);
        if (isReturnedOnTime(bookToReturn, LocalDate.now())) {
            logger.info("Book returned successfully!");
        }
        logger.info("Book returned too late!");
    }

    private String getInssFromLendingId(String lendingID) {
        return lendingID.split(DEFAULT_LENDING_ID_SPLITTER)[1];
    }
}
