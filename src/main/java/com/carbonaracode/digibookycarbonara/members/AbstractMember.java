package com.carbonaracode.digibookycarbonara.members;

import com.carbonaracode.digibookycarbonara.Name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractMember {
    public static final String OWASP_EMAIL_VALIDATION = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private final String inss;
    private final Name name;
    private final String email;

    public AbstractMember(String inss, Name name, String email) {
        validateEmail(email);
        validateInss(inss);
        this.inss = inss;
        this.name = name;
        this.email = email;
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


    private void validateEmail(String email) throws IllegalArgumentException {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        Pattern pattern = Pattern.compile(OWASP_EMAIL_VALIDATION);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("invalid e-mail format");
        }
    }

    private void validateInss(String inss) {
        if (inss == null || inss.isBlank()) {
            throw new IllegalArgumentException("INSS cannot be empty!");
        }
    }

}
