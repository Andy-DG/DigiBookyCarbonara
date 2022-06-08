package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.Book;

import java.time.LocalDate;
import java.util.UUID;

public class LentBook extends Book {


    private final static int DEFAULT_DUE_WEEKS = 3;

    private final UUID lendingID;
    private final LocalDate dueDate;

    public LentBook(BookBuilder builder) {
        super(builder);
        this.lendingID = UUID.randomUUID();
        this.dueDate = calculateDueDate();
    }

    private static LocalDate calculateDueDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.plusWeeks(DEFAULT_DUE_WEEKS);
    }

    public UUID getLendingID() {
        return lendingID;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
