package com.carbonaracode.digibookycarbonara.books;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {
    private Map<String, Book> books;

    public BookRepository() {
        this.books = new HashMap<>();
    }

    public Book addBook(Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }

    public List<Book> getAll() {
        return books.values().stream().toList();
    }

}
