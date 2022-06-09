package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.Author;

import java.time.LocalDate;

public class LentBookDTO {

    private final String isbn;
    private final String title;
    private final String authorFirstname;
    private final String authorLastname;
    private final String summary;
    private final String lendingID;
    private final LocalDate dueDate;

    public LentBookDTO(String isbn, String title, String summary, String authorFirstname, String authorLastname, String lendingID, LocalDate dueDate) {
        this.isbn = isbn;
        this.title = title;

        this.authorFirstname = authorFirstname;
        this.authorLastname = authorLastname;

        this.summary = summary;
        this.lendingID = lendingID;
        this.dueDate = dueDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFirstname() {
        return authorFirstname;
    }

    public String getAuthorLastname() {
        return authorLastname;
    }

    public String getSummary() {
        return summary;
    }

    public Author retrieveAuthor() {
        return new Author(this.authorFirstname, this.authorLastname);
    }

    public String getLendingID() {
        return lendingID;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
