package com.carbonaracode.digibookycarbonara.books;

public class BookDTO {
    private final String isbn;
    private final String title;
    private final String authorFirstname;
    private final String authorLastname;
    private final String summary;

    public BookDTO(String isbn, String title, String summary, String authorFirstname, String authorLastname) {
        this.isbn = isbn;
        this.title = title;

        this.authorFirstname = authorFirstname;
        this.authorLastname = authorLastname;

        this.summary = summary;
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
}
