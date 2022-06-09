package com.carbonaracode.digibookycarbonara.books;

import com.carbonaracode.digibookycarbonara.lending.LentBookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "books")
public class BookController {
    private final BookService bookService;
    public static final Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = "application/json")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }


    @GetMapping(path = "/{isbn}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBookDetailByIsbn(@PathVariable String isbn) {
        logger.info("Get called for book with isbn " + isbn);
        BookDTO bookByIsbn = this.bookService.getBookByIsbn(isbn);
        logger.info("retrieved book: " + bookByIsbn.getIsbn());
        return bookByIsbn;
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO registerNewBook(@RequestBody CreateBookDTO createBookDTO){
        // NOT IMPLEMENTED (No roles yet)
        // If any other user besides a Librarian tries to register a new book,
        // the server should respond with 403 Forbidden and a custom message.

        logger.info("Registered called for a book with ISBN: " + createBookDTO.getIsbn());
        return this.bookService.registerNewBook(createBookDTO);
    }




}
