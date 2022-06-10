package com.carbonaracode.digibookycarbonara.books;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDTO> getAllBooks() {
        return bookMapper.toDTO(bookRepository.getAll());
    }

    public BookDTO getBookByIsbn(String id){
        return this.bookMapper.toDTO(this.bookRepository.getBookByIsbn(id));
    }

    public BookDTO registerNewBook(CreateBookDTO createBookDTO) {
        checkCopiesLessThanZero(createBookDTO);
        checkPriceLessThanZero(createBookDTO);

        checkAgainstBlankOrNull(
                createBookDTO.getIsbn(),
                createBookDTO.getTitle(),
                createBookDTO.getAuthorFirstName(),
                createBookDTO.getAuthorLastName(),
                createBookDTO.getImageURL()
        );


        Book book = this.bookMapper.toEntity(createBookDTO);
        this.bookRepository.addBook(book);
        return this.bookMapper.toDTO(book);
    }

    private void checkAgainstBlankOrNull(String... in){
        for(String input : in)
            if(input == null || input.isBlank()) throw new IllegalArgumentException("Field cannot be blank");
    }

    private void checkPriceLessThanZero(CreateBookDTO createBookDTO) {
        if(createBookDTO.getPrice() < 0) throw new IllegalArgumentException("Price cannot be less than zero");
    }

    private void checkCopiesLessThanZero(CreateBookDTO createBookDTO) {
        if(createBookDTO.getCopies() < 0) throw new IllegalArgumentException("Amount of copies cannot be less than zero");
    }

    public List<Book> searchBooksByIsbn(String isbn) {
        return bookRepository.searchBooksByIsbn(isbn);
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.searchBooksByTitle(title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return bookRepository.searchBooksByAuthor(author);
    }
}
