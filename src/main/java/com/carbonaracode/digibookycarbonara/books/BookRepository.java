package com.carbonaracode.digibookycarbonara.books;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {
    private Map<String, Book> books;

    public BookRepository() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public List<Book> getAll() {
        return books.values().stream().toList();
    }

}
