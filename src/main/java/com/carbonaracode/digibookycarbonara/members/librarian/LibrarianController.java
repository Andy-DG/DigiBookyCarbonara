package com.carbonaracode.digibookycarbonara.members.librarian;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/librarians")
public class LibrarianController {
        LibrarianService librarianService;

    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    //http://localhost:4200/librarians/add
    @PostMapping(path="/add", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    LibrarianDTO addLibrarian(CreateLibrarionDTO createLibrarionDTO){
        return this.librarianService.addLibrarian(createLibrarionDTO);
    }


}
