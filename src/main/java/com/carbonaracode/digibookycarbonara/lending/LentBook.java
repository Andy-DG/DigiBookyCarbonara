package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.Book;

import java.time.LocalDate;
import java.util.Objects;

public class LentBook extends Book {


    private final static int DEFAULT_DUE_WEEKS = 3;

    private final String lendingID;
    private final LocalDate dueDate;

    public LentBook(BookBuilder builder, String lendingID) {
        super(builder);
        this.lendingID = lendingID;
        this.dueDate = calculateDueDate();
    }

    private static LocalDate calculateDueDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.plusWeeks(DEFAULT_DUE_WEEKS);
    }

    public String getLendingID() {
        return lendingID;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "LentBook{" +
                "lendingID='" + lendingID + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LentBook lentBook = (LentBook) o;
        return lendingID.equals(lentBook.lendingID) && dueDate.equals(lentBook.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lendingID, dueDate);
    }
}
