package com.carbonaracode.digibookycarbonara.members.librarian;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('REGISTER_NEW_LIBRARIAN')")
    @PostMapping(path="/add", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    LibrarianDTO addLibrarian(@RequestBody CreateLibrarianDTO createLibrarianDTO){
        logger.info(createLibrarianDTO.toString());
        return this.librarianService.addLibrarian(createLibrarianDTO);
    }


}
