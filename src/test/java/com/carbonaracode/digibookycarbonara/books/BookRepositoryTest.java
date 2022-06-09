package com.carbonaracode.digibookycarbonara.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class BookRepositoryTest {
    private final Book book = Book.newBuilder()
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

    @Test
    @DisplayName("Given a map of books, when we request all books, then we get a list of all books")
    void givenAMapOfBooksWhenWeRequestAllBooksThenWeGetAListOfAllBooks() {
        //Given
        BookRepository bookRepository = new BookRepository();
        bookRepository.addBook(book);

        //When
        List<Book> actualResult = bookRepository.getAll();

        //Then
        Assertions.assertEquals(List.of(book), actualResult);
    }

    @Test
    @DisplayName("Given a repository, when we search a book by isbn null, then we throw an exception")
    void givenARepositoryWhenWeSearchABookByIsbnNullThenWeThrowAnException() {
        //Given
        BookRepository bookRepository = new BookRepository();

        //When

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> bookRepository.getBookByIsbn(null));
    }

    @Test
    @DisplayName("Given a repository, when we search a book by isbn blank, then we throw an exception")
    void givenARepositoryWhenWeSearchABookByIsbnBlankThenWeThrowAnException() {
        //Given
        BookRepository bookRepository = new BookRepository();

        //When

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> bookRepository.getBookByIsbn(""));
    }

    @Test
    @DisplayName("Given a repository, when we search a book by isbn that is not in the repository, throw new exception.")
    void givenARepositoryWhenWeSearchABookByIsbnThatIsNotInTheRepositoryThrowNewException() {
        //Given
        BookRepository bookRepository = new BookRepository();

        //When

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> bookRepository.getBookByIsbn("54546"));
    }

    @Test
    @DisplayName("Given a repository, when we search a book by isbn that is in the repository, then we get that book.")
    void givenARepositoryWhenWeSearchABookByIsbnThatIsInTheRepositoryThenWeGetThatBook() {
        //Given
        BookRepository bookRepository = new BookRepository();
        bookRepository.addBook(book);

        //When
        Book actual = bookRepository.getBookByIsbn("978-1-4028-9462-6");

        //Then
        Assertions.assertEquals(book, actual);
    }
}