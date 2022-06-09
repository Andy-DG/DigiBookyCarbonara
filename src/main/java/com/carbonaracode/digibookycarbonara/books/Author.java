package com.carbonaracode.digibookycarbonara.books;

import com.carbonaracode.digibookycarbonara.Name;

public record Author(String authorFirstname, String authorLastname){

    @Override
    public String authorFirstname() {
        return authorFirstname;
    }

    @Override
    public String authorLastname() {
        return authorLastname;
    }
}
