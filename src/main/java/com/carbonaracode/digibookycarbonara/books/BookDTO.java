package com.carbonaracode.digibookycarbonara.books;

public class BookDTO {
    private final String isbn;
    private final String title;
    private final Author author;
    private final String summary;

    public BookDTO(String isbn, String title, Author author, String summary) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.summary = summary;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getSummary() {
        return summary;
    }
}
