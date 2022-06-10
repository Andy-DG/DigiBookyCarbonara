package com.carbonaracode.digibookycarbonara.members.librarian;

public class CreateLibrarionDTO {
    private final String inss, email, firstname, lastname, password;

    public CreateLibrarionDTO(String inss, String email, String firstname, String lastname, String password) {
        this.inss = inss;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getInss() {
        return this.inss;
    }
}
