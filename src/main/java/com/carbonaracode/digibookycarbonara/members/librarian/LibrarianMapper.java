package com.carbonaracode.digibookycarbonara.members.librarian;

import com.carbonaracode.digibookycarbonara.Name;
import org.springframework.stereotype.Component;

@Component
public class LibrarianMapper {
    public Librarian toEntity(CreateLibrarionDTO createLibrarionDTO) {
        return new Librarian(
                createLibrarionDTO.getInss(),
                new Name(createLibrarionDTO.getFirstname(), createLibrarionDTO.getLastname()),
                createLibrarionDTO.getEmail()
                );
    }

    public LibrarianDTO toDTO(Librarian librarian) {
        return new LibrarianDTO(librarian.getInss(), librarian.getName(), librarian.getEmail());
    }
}
