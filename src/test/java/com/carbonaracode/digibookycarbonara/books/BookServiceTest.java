package com.carbonaracode.digibookycarbonara.books;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    static String bookID;
    static BookRepository bookRepository;
    static Book book;
    static BookMapper bookMapper;
    static BookService bookService;

    @BeforeAll
    static void setUp(){
        bookID = "onr12*155*484";
        bookRepository = new BookRepository();
        book = Book.newBuilder().withIsbn(bookID)
                .withAuthor(new Author("John", "Doe"))
                .withTitle("Viva Las Vegas")
                .withSummary("If anyone has a copy of the Die Hard Viva Las Vegas game, please call me")
                .build();
        bookRepository.addBook(book);

        bookMapper = new BookMapper();
        bookService = new BookService(bookRepository, bookMapper);
    }

    @Test
    @DisplayName("Given the id of an existing book, when searching the book, return the book")
    void givenValidId_WhenSearching_ThenReturnBook(){
        String bookToFind = "onr12*155*484";
        BookDTO bookById = bookService.getBookById(bookToFind);

        assertEquals(bookID, bookById.getIsbn());
    }

    @Test
    @DisplayName("Given the id of an non-existent book, when searching the book, return throw error")
    void givenInValidId_WhenSearching_ThenReturnBook(){
        String bookToFind = "not here";

        assertThrows(IllegalArgumentException.class, ()-> bookService.getBookById(bookToFind));
    }

}