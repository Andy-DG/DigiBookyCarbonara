package com.carbonaracode.digibookycarbonara.books;

public class Book {
    private final String isbn;
    private final String title;
    private final Author author;
    private final String summary;

    private Book(Builder builder) {
        isbn = builder.isbn;
        title = builder.title;
        author = builder.author;
        summary = builder.summary;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String isbn;
        private String title;
        private Author author;
        private String summary;

        private Builder() {
        }

        public Builder withIsbn(String val) {
            isbn = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withAuthor(Author val) {
            author = val;
            return this;
        }

        public Builder withSummary(String val) {
            summary = val;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public String getIsbn() {
        return isbn;
    }
}
