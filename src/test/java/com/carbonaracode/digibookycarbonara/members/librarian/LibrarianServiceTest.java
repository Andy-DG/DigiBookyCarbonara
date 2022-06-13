package com.carbonaracode.digibookycarbonara.members.librarian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibrarianServiceTest {
    LibrarianMapper librarianMapper;
    LibrarianRepository librarianRepository;

            @BeforeEach
            void beforeEach(){
                this.librarianMapper = new LibrarianMapper();
                this.librarianRepository = new LibrarianRepository();
            }

    @Test
    @DisplayName("Given a librarian with proper fields, when registering librarian, then success")
    void givenLibrarianWithProperFields_whenRegistering_thenSuccess() {
        String inss = UUID.randomUUID().toString();
        CreateLibrarionDTO createLibrarionDTO = new CreateLibrarionDTO(inss, "libr@vox.com", "John", "Doe", "12345pass");

        this.librarianRepository.registerLibrarian(this.librarianMapper.toEntity(createLibrarionDTO));

        assertTrue(this.librarianRepository.getMap().containsKey(createLibrarionDTO.getInss()));
    }


    @Test
    @DisplayName("Given two librarian with proper fields but same isnn, when registering, then exception")
    void givenTwoLibrarianWithSameIsnn_whenRegistering_throwException() {
        String inss = UUID.randomUUID().toString();
        CreateLibrarionDTO createLibrarionDTO = new CreateLibrarionDTO(inss, "libr@vox.com", "John", "Doe", "12345pass");
        CreateLibrarionDTO createLibrarionDTO2 = new CreateLibrarionDTO(inss, "frr@vox.com", "Fred", "Mex", "54321wordup");

        this.librarianRepository.registerLibrarian(this.librarianMapper.toEntity(createLibrarionDTO));

        assertThrows(IllegalArgumentException.class, ()-> this.librarianRepository.registerLibrarian(this.librarianMapper.toEntity((createLibrarionDTO2))));
    }

    @Test
    @DisplayName("When creating a librarian with no inss, throw Exception")
    void whenCreatingLibrarianWithNoInss_throwException() {
        CreateLibrarionDTO createLibrarionDTO = new CreateLibrarionDTO(" ", "libr@vox.com", "John", "Doe", "12345pass");
        assertThrows(IllegalArgumentException.class, ()-> this.librarianMapper.toEntity(createLibrarionDTO));
    }

    @Test
    @DisplayName("When creating a librarian with bad email, throw Exception")
    void whenCreatingLibrarianWithbadEmail_throwException() {
        String inss = UUID.randomUUID().toString();
        CreateLibrarionDTO createLibrarionDTO = new CreateLibrarionDTO(inss, "john@gmail", "John", "Doe", "12345pass");
        assertThrows(IllegalArgumentException.class, ()-> this.librarianMapper.toEntity(createLibrarionDTO));
    }

}
