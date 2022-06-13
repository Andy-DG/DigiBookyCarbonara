package com.carbonaracode.digibookycarbonara.books;

import com.carbonaracode.digibookycarbonara.lending.LendingService;
import com.carbonaracode.digibookycarbonara.lending.LentBookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "books")
public class BookController {
    private final BookService bookService;
    private final LendingService lendingService;
    public static final Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService bookService, LendingService lendingService) {
        this.bookService = bookService;
        this.lendingService = lendingService;
    }

    @PreAuthorize("hasAuthority('VIEW_ALL_BOOKS')")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> searchBooksByIsbn(@RequestParam(required = false) String isbn, @RequestParam(required = false) String title, @RequestParam(required = false) String author) {
        if (isbn != null) {
            return bookService.searchBooksByIsbn(isbn);
        }
        if (title != null) {
            return bookService.searchBooksByTitle(title);
        }
        if (author != null) {
            return bookService.searchBooksByAuthor(author);
        }
        return bookService.getAllBooks();
    }

    @PreAuthorize("hasAuthority('VIEW_ALL_BOOKS')")
    @GetMapping(path = "/{isbn}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBookDetailByIsbn(@PathVariable String isbn) {
        logger.info("Get called for book with isbn " + isbn);
        BookDTO bookByIsbn = this.bookService.getBookByIsbn(isbn);
        logger.info("retrieved book: " + bookByIsbn.getIsbn());
        return bookByIsbn;
    }

    @PreAuthorize("hasAuthority('ADD_BOOKS')")
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO registerNewBook(@RequestBody CreateBookDTO createBookDTO) {
        // NOT IMPLEMENTED (No roles yet)
        // If any other user besides a Librarian tries to register a new book,
        // the server should respond with 403 Forbidden and a custom message.

        logger.info("Registered called for a book with ISBN: " + createBookDTO.getIsbn());
        return this.bookService.registerNewBook(createBookDTO);
    }

    @PreAuthorize("hasAuthority('LEND_BOOK')")
    @PostMapping(path = "/{inss}/{isbn}/lent", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public LentBookDTO lendBook(@PathVariable String inss, @PathVariable String isbn) {
        logger.info("Post called to lend to member " + inss + " and book " + isbn);
        return lendingService.lendBook(isbn, inss);
    }

    @PreAuthorize("hasAuthority('RETURN_BOOK')")
    @PostMapping(path = "/{inss}/{isbn}/return", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void returnBook(@PathVariable String inss, @PathVariable String isbn) {
        logger.info("Post called for member " + inss + " to return lent book " + isbn);
        lendingService.returnBook(isbn);
    }
}
