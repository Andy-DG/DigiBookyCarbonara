package com.carbonaracode.digibookycarbonara.members;

public class Member {
//This member should have a unique INSS (social security number), last name, first name, email, street name, street number,
// postal code and city.
    private final String inss;
    private final Name name;
    private final String email;
    private final Address address;

    public Member(String inss, Name name, String email, Address address) {
        this.inss = inss;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getInss() {
        return inss;
    }

    public Name getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
