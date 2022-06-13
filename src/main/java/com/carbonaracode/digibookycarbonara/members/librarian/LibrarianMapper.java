package com.carbonaracode.digibookycarbonara.members.librarian;

import com.carbonaracode.digibookycarbonara.Name;
import org.springframework.stereotype.Component;

@Component
public class LibrarianMapper {
    public Librarian toEntity(CreateLibrarianDTO createLibrarianDTO) {
        return new Librarian(
                createLibrarianDTO.getInss(),
                new Name(createLibrarianDTO.getFirstname(), createLibrarianDTO.getLastname()),
                createLibrarianDTO.getEmail()
                );
    }

    public LibrarianDTO toDTO(Librarian librarian) {
        return new LibrarianDTO(librarian.getInss(), librarian.getName(), librarian.getEmail());
    }
}
