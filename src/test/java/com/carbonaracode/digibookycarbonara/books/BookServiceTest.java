package com.carbonaracode.digibookycarbonara.books;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookServiceTest {
    static String bookID;
    static BookRepository bookRepository;
    static Book book;
    static BookMapper bookMapper;
    static BookService bookService;

    @BeforeAll
    static void setUp(){
        bookID = UUID.randomUUID().toString();
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
    void givenValidId_WhenSearching_ThenReturnBook() {
        BookDTO bookById = bookService.getBookByIsbn(bookID);
    }

    @Nested
    class SearchBooks{
        @Test
        @DisplayName("Given the id of an existing book, when searching the book, return the book")
        void givenValidId_WhenSearching_ThenReturnBook(){
            BookDTO bookById = bookService.getBookByIsbn(bookID);

            assertEquals(bookID, bookById.getIsbn());
        }

        @Test
        @DisplayName("Given the id of an non-existent book, when searching the book, return throw error")
        void givenInValidId_WhenSearching_ThenReturnBook(){
            String bookToFind = "not here";

            assertThrows(IllegalArgumentException.class, ()-> bookService.getBookByIsbn(bookToFind));
        }
    }

    @Nested
    class AddBook{
        @Test
        @DisplayName("When registering a new book, given no null or blank values and isbn is unique, then success")
        void whenRegisteringABook_givenNoNullsOrBlanksAndISBNisUnique_thenSuccess(){
            CreateBookDTO createBookDTO
                    = new CreateBookDTO(UUID.randomUUID().toString(), "test", "Mc", "T", 1.99, 5, "www.ex.com/1.jpeg");

            BookDTO book1 = bookService.registerNewBook(createBookDTO);

            assertEquals(createBookDTO.getIsbn(), book1.getIsbn());
            assertEquals(createBookDTO.getAuthorFirstName(), book1.getAuthorFirstname());
        }

        @Test
        @DisplayName("When registering a new book, given no null or blank values and isbn is NOT unique, then throw exception")
        void whenRegisteringABook_givenNoNullsOrBlanksAndISBNisNOTUnique_throwException(){
            String idToAdd = UUID.randomUUID().toString();

            CreateBookDTO createBookDTO
                    = new CreateBookDTO(idToAdd, "test", "Mc", "T", 1.99, 5, "www.ex.com/1.jpeg");

            CreateBookDTO createBookDTO2
                                = new CreateBookDTO(idToAdd, "fuzz", "Aldred", "B", 5.88, 9, "www.ex.com/1.jpeg");

            BookDTO book1 = bookService.registerNewBook(createBookDTO);

            assertThrows(IllegalArgumentException.class, () -> bookService.registerNewBook(createBookDTO2));
        }


        @Test
        @DisplayName("When registering a new book, given a blank or null field, then throw exception")
        void whenRegisteringABook_givenABlankOrNullField_throwException(){
            String idToAdd = UUID.randomUUID().toString();

            CreateBookDTO createBookDTO
                    = new CreateBookDTO(idToAdd, " ", "Mc", "T", 1.99, 5, "www.ex.com/1.jpeg");

            assertThrows(IllegalArgumentException.class, () -> bookService.registerNewBook(createBookDTO));
        }

        @Test
        @DisplayName("When registering a new book, given a negative price or copies amount, then throw exception")
        void whenRegisteringABook_givenNegativePriceOrCopyAmount_throwException(){
            String idToAdd = UUID.randomUUID().toString();
            CreateBookDTO createBookDTO
                    = new CreateBookDTO(idToAdd, "try", "Mc", "T", -1.99, 5, "www.ex.com/1.jpeg");

            assertThrows(IllegalArgumentException.class, () -> bookService.registerNewBook(createBookDTO));
        }


    }


}
