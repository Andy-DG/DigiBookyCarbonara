package com.carbonaracode.digibookycarbonara.books;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {
    public Book toEntity(BookDTO bookDTO) {
        return Book.newBuilder()
                .withIsbn(bookDTO.getIsbn())
                .withTitle(bookDTO.getTitle())
                .withAuthor(bookDTO.retrieveAuthor())
                .withSummary(bookDTO.getSummary())
                .build();
    }

    public BookDTO toDTO(Book book) {
        return new BookDTO(book.getIsbn(), book.getTitle(), book.getSummary(), book.getAuthor().authorFirstname(), book.getAuthor().authorLastname());
    }

    public List<BookDTO> toDTO(List<Book> bookList) {
        return bookList.stream().map(this::toDTO).toList();
    }
}
