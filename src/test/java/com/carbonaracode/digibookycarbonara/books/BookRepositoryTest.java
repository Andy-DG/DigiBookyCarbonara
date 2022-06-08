package com.carbonaracode.digibookycarbonara.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {
    private Book book1 = Book.newBuilder()
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
        bookRepository.addBook(book1);
        //when
        List<Book> actualResult = bookRepository.getAll();
        //then
        Assertions.assertEquals(List.of(book1), actualResult);
    }

}