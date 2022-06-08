package com.carbonaracode.digibookycarbonara.members;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Member {
//This member should have a unique INSS (social security number), last name, first name, email, street name, street number,
// postal code and city.
    private final String inss;
    private final Name name;
    private final String email;
    private final Address address;

    public Member(String inss, Name name, String email, Address address) {
        validateEmail(email);
        this.inss = inss;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    private void validateEmail(String email) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile( "^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()){
            throw new IllegalArgumentException("invalid e-mail format");
        }
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
