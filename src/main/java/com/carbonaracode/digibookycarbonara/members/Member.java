package com.carbonaracode.digibookycarbonara.members;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.carbonaracode.digibookycarbonara.Name;

public class Member {
//This member should have a unique INSS (social security number), last name, first name, email, street name, street number,
// postal code and city.
    private final String inss;
    private final Name name;
    private final String email;
    private final Address address;

    private Member(Builder builder) {
        inss = builder.inss;
        name = builder.name;
        email = builder.email;
        address = builder.address;
    }

    public static Builder newBuilder() {
        return new Builder();
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


    public static final class Builder {
        private String inss;
        private Name name;
        private String email;
        private Address address;

        private Builder() {
        }

        public Builder withInss(String inss) {
            validateInss(inss);
            this.inss = inss;
            return this;
        }

        public Builder withName(Name name) {
            this.name = name;
            return this;
        }

        public Builder withEmail(String email) {
            validateEmail(email);
            this.email = email;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Member build() {
            return new Member(this);
        }

        private void validateEmail(String email) throws IllegalArgumentException {
            if (email == null){
                throw new IllegalArgumentException("Email cannot be empty");
            }
            Pattern pattern = Pattern.compile( "^(.+)@(.+)$");
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()){
                throw new IllegalArgumentException("invalid e-mail format");
            }
        }

        private void validateInss(String inss){
            if (inss == null || inss.isBlank()){
                throw new IllegalArgumentException("INSS cannot be empty!");
            }
        }
    }
}
