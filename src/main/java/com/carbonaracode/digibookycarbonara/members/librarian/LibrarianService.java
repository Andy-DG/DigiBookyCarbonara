package com.carbonaracode.digibookycarbonara.members.librarian;

import com.carbonaracode.digibookycarbonara.security.KeycloakService;
import com.carbonaracode.digibookycarbonara.security.KeycloakUserDTO;
import com.carbonaracode.digibookycarbonara.security.Role;
import org.springframework.stereotype.Service;

@Service
public class LibrarianService {
    LibrarianRepository librarianRepository;
    LibrarianMapper librarianMapper;
    KeycloakService keycloakService;


    public LibrarianService(LibrarianRepository librarianRepository, LibrarianMapper librarianMapper, KeycloakService keycloakService) {
        this.librarianRepository = librarianRepository;
        this.librarianMapper = librarianMapper;
        this.keycloakService = keycloakService;
    }

    LibrarianDTO addLibrarian(CreateLibrarianDTO createLibrarianDTO){
        Librarian librarian = librarianMapper.toEntity(createLibrarianDTO);
        librarianRepository.registerLibrarian(librarian);
//        keycloakService.addUser(new KeycloakUserDTO(createLibrarianDTO.getLastname(),createLibrarianDTO.getPassword(), Role.LIBRARIAN));
        return librarianMapper.toDTO(librarian);
    }


}
