package com.carbonaracode.digibookycarbonara.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {
    public static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private Map<String, Book> bookMap;

    public BookRepository() {
        this.bookMap = createAndInitializeBookMap();
    }

    public Map<String, Book> createAndInitializeBookMap() {
        Book book1 = Book.newBuilder()
                .withIsbn("978-1-4028-9462-6")
                .withTitle("The Phoenix Project")
                .withAuthor(new Author("Gene", "Kim"))
                .withSummary("Bill is an IT manager at Parts Unlimited. " +
                        "It's Tuesday morning and on his drive into the office, Bill gets a call from the CEO.\n" +
                        "\n" +
                        "The company's new IT initiative, code named Phoenix Project, is critical to the future of Parts Unlimited, " +
                        "but the project is massively over budget and very late. " +
                        "The CEO wants Bill to report directly to him and fix the mess in ninety days " +
                        "or else Bill's entire department will be outsourced.\n")
                .build();

        Book book2 = Book.newBuilder()
                .withTitle("The Odyssey")
                .withAuthor(new Author("", "Homer"))
                .withIsbn("978-0140268867")
                .withSummary("If the Iliad is the world's greatest war epic, the Odyssey is literature's grandest evocation of an everyman's journey through life. " +
                        "\n Odysseus' reliance on his wit and wiliness for survival in his encounters with divine and natural forces during his ten-year voyage home to Ithaca after the Trojan War is at once a timeless human story and an individual test of moral endurance. ")
                .build();

        bookMap = new HashMap<>();
        bookMap.put(book1.getIsbn(), book1);
        bookMap.put(book2.getIsbn(), book2);
        return bookMap;
    }


    public void addBook(Book book) {
        if (bookMap.containsKey(book.getIsbn()))
            throw new IllegalArgumentException("Book with ISBN " + book.getIsbn() + " already registered");
        bookMap.put(book.getIsbn(), book);
    }

    public List<Book> getAll() {
        return bookMap.values().stream().toList();
    }

    public Book getBookByIsbn(String isbn) {
        checkNotNull(isbn);
        checkInMap(isbn);

        return this.bookMap.get(isbn);
    }

    private void checkInMap(String isbn) throws IllegalArgumentException {
        if (!this.bookMap.containsKey(isbn))
            throw new IllegalArgumentException("No book with called isbn found " + isbn);
    }

    private void checkNotNull(String id) throws IllegalArgumentException {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id cannot be blank or null");
    }

    public Map<String, Book> getBookMap() {
        return bookMap;
    }

    public List<Book> searchBooksByIsbn(String isbnPart) {
        List<Book> bookList =bookMap.values().stream().filter(book -> book.getIsbn().contains(isbnPart)).toList();
        logger.info(String.valueOf(bookList));
        return bookList;
    }
}
