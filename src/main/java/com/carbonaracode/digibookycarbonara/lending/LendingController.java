package com.carbonaracode.digibookycarbonara.lending;

import com.carbonaracode.digibookycarbonara.books.BookController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "books")
public class LendingController {
    private final LendingService lendingService;
    public static final Logger logger = LoggerFactory.getLogger(BookController.class);

    public LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @PostMapping(path = "/{inss}/{isbn}/lent", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public LentBookDTO LendBook(@PathVariable String inss, @PathVariable String isbn) {
        logger.info("Post called to lend a book " + isbn + " to member " + inss);
        return lendingService.lendBook(inss, isbn);
    }
}
