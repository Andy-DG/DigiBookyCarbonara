package com.carbonaracode.digibookycarbonara.books;

public class Book {
    private final String isbn;
    private final String title;
    private final Author author;
    private final String summary;

    protected Book(BookBuilder builder) {
        isbn = builder.isbn;
        title = builder.title;
        author = builder.author;
        summary = builder.summary;
    }

    public static BookBuilder newBuilder() {
        return new BookBuilder();
    }

    public static BookBuilder newBuilder(Book book) {
        return Book.newBuilder()
                .withTitle(book.getTitle())
                .withAuthor(book.getAuthor())
                .withIsbn(book.getISBN())
                .withSummary(book.getSummary());
    }

    public static final class BookBuilder {
        private String isbn;
        private String title;
        private Author author;
        private String summary;

        private BookBuilder() {
        }


        public BookBuilder withIsbn(String val) {
            isbn = val;
            return this;
        }

        public BookBuilder withTitle(String val) {
            title = val;
            return this;
        }

        public BookBuilder withAuthor(Author val) {
            author = val;
            return this;
        }

        public BookBuilder withSummary(String val) {
            summary = val;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public String getISBN() {
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
