package com.carbonaracode.digibookycarbonara.members.librarian;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/librarians")
public class LibrarianController {
    Logger logger = Logger.getLogger(this.getClass().getName());
        LibrarianService librarianService;

    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    //http://localhost:4200/librarians/add
    @PostMapping(path="/add", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    LibrarianDTO addLibrarian(@RequestBody CreateLibrarionDTO createLibrarionDTO){
        logger.info(createLibrarionDTO.toString());
        return this.librarianService.addLibrarian(createLibrarionDTO);
    }


}
