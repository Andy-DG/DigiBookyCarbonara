package com.carbonaracode.digibookycarbonara.books;

import com.carbonaracode.digibookycarbonara.Name;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {
    private Map<String, Book> bookMap;

    public BookRepository() {
        this.bookMap = createAndInitializeBookMap();
    }

    public Map<String, Book> createAndInitializeBookMap() {
        Book book1 = Book.newBuilder()
                .withIsbn("978-1-4028-9462-6")
                .withTitle("The Phoenix Project")
                .withAuthor(new Author(new Name("Gene", "Kim")))
                .withSummary("Bill is an IT manager at Parts Unlimited. " +
                        "It's Tuesday morning and on his drive into the office, Bill gets a call from the CEO.\n" +
                        "\n" +
                        "The company's new IT initiative, code named Phoenix Project, is critical to the future of Parts Unlimited, " +
                        "but the project is massively over budget and very late. " +
                        "The CEO wants Bill to report directly to him and fix the mess in ninety days " +
                        "or else Bill's entire department will be outsourced.\n")
                .build();
        bookMap = new HashMap<>();
        bookMap.put(book1.getIsbn(), book1);
        return bookMap;
    };

    public void addBook(Book book) {
        bookMap.put(book.getIsbn(), book);
    }

    public List<Book> getAll() {
        return bookMap.values().stream().toList();
    }

    public Book getBookById(String id) {
        checkNotNull(id);
        checkInMap(id);

        return this.bookMap.get(id);
    }

    private void checkInMap(String id) {
        if(!this.bookMap.containsKey(id)) throw new IllegalArgumentException("No book with called isbn found");
    }

    private void checkNotNull(String id) {
        if(id == null || id.isBlank()) throw new IllegalArgumentException("id cannot be blank or null");
    }
}
