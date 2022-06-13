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
        CreateLibrarianDTO createLibrarianDTO = new CreateLibrarianDTO(inss, "libr@vox.com", "John", "Doe", "12345pass");

        this.librarianRepository.registerLibrarian(this.librarianMapper.toEntity(createLibrarianDTO));

        assertTrue(this.librarianRepository.getMap().containsKey(createLibrarianDTO.getInss()));
    }


    @Test
    @DisplayName("Given two librarian with proper fields but same isnn, when registering, then exception")
    void givenTwoLibrarianWithSameIsnn_whenRegistering_throwException() {
        String inss = UUID.randomUUID().toString();
        CreateLibrarianDTO createLibrarianDTO = new CreateLibrarianDTO(inss, "libr@vox.com", "John", "Doe", "12345pass");
        CreateLibrarianDTO createLibrarianDTO2 = new CreateLibrarianDTO(inss, "frr@vox.com", "Fred", "Mex", "54321wordup");

        this.librarianRepository.registerLibrarian(this.librarianMapper.toEntity(createLibrarianDTO));

        assertThrows(IllegalArgumentException.class, ()-> this.librarianRepository.registerLibrarian(this.librarianMapper.toEntity((createLibrarianDTO2))));
    }

    @Test
    @DisplayName("When creating a librarian with no inss, throw Exception")
    void whenCreatingLibrarianWithNoInss_throwException() {
        CreateLibrarianDTO createLibrarianDTO = new CreateLibrarianDTO(" ", "libr@vox.com", "John", "Doe", "12345pass");
        assertThrows(IllegalArgumentException.class, ()-> this.librarianMapper.toEntity(createLibrarianDTO));
    }

    @Test
    @DisplayName("When creating a librarian with bad email, throw Exception")
    void whenCreatingLibrarianWithbadEmail_throwException() {
        String inss = UUID.randomUUID().toString();
        CreateLibrarianDTO createLibrarianDTO = new CreateLibrarianDTO(inss, "john@gmail", "John", "Doe", "12345pass");
        assertThrows(IllegalArgumentException.class, ()-> this.librarianMapper.toEntity(createLibrarianDTO));
    }

}
