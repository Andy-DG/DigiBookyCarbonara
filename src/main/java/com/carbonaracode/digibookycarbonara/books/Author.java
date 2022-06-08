package com.carbonaracode.digibookycarbonara.books;

import com.carbonaracode.digibookycarbonara.Name;

public class Author {
    private final Name name;

    public Author(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
