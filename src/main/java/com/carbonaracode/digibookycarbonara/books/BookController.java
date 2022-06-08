package com.carbonaracode.digibookycarbonara.books;

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


    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBookDetailById(@PathVariable String id){
        logger.info("Get called for book with id " + id);
        BookDTO bookById = this.bookService.getBookById(id);
        logger.info("retrieved book: " + bookById.getIsbn());
        return bookById;
    }


}
