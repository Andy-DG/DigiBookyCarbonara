package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.Book;
import com.carbonaracode.digibookycarbonara.books.BookDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LentBookMapper {
    public LentBook toEntity(LentBookDTO lentBookDTO) {
        return new LentBook(Book.newBuilder()
                .withIsbn(lentBookDTO.getIsbn())
                .withAuthor(lentBookDTO.retrieveAuthor())
                .withTitle(lentBookDTO.getTitle())
                .withSummary(lentBookDTO.getSummary())
                , lentBookDTO.getLendingID());
    }

    public LentBookDTO toDTO(LentBook lentBook) {
        return new LentBookDTO(lentBook.getIsbn(), lentBook.getTitle(), lentBook.getSummary(),
                lentBook.getAuthor().authorFirstname(), lentBook.getAuthor().authorLastname(),
                lentBook.getLendingID(), lentBook.getDueDate());
    }

    public List<LentBookDTO> toDTO(List<LentBook> lentBookList) {
        return lentBookList.stream().map(this::toDTO).toList();
    }
}
