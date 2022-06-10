package com.carbonaracode.digibookycarbonara.members.librarian;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Repository
public class LibrarianRepository {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final Map<String, Librarian> librarianMap;

    public LibrarianRepository() {
        this.librarianMap = new HashMap<>();
    }

    void registerLibrarian(Librarian librarian){
        checkIfAlreadyExists(librarian);
        this.librarianMap.put(librarian.getInss(), librarian);
        logger.info("Registered librarian with inss " + librarian.getInss());
    }

    private void checkIfAlreadyExists(Librarian librarian) {
        if(this.librarianMap.containsKey(librarian.getInss())) {
            logger.warning("Librarian with inss " + librarian.getInss() + " already registered");
            throw new IllegalArgumentException("Librarian with inss " + librarian.getInss() + " already registered");
        }
    }

    public Map<String, Librarian> getMap() {
        return Collections.unmodifiableMap(this.librarianMap);
    }
}
