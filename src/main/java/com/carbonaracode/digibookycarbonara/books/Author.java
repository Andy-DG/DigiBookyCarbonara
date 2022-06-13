package com.carbonaracode.digibookycarbonara.books;

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
