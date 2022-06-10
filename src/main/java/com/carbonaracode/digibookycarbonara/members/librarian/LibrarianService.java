package com.carbonaracode.digibookycarbonara.members.librarian;

import org.springframework.stereotype.Service;

@Service
public class LibrarianService {
    LibrarianRepository librarianRepository;
    LibrarianMapper librarianMapper;

    public LibrarianService(LibrarianRepository librarianRepository, LibrarianMapper librarianMapper) {
        this.librarianRepository = librarianRepository;
        this.librarianMapper = librarianMapper;
    }

    LibrarianDTO addLibrarian(CreateLibrarionDTO createLibrarionDTO){
        Librarian librarian = librarianMapper.toEntity(createLibrarionDTO);
        librarianRepository.registerLibrarian(librarian);
        return librarianMapper.toDTO(librarian);
    }
}
