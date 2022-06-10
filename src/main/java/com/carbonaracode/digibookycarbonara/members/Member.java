package com.carbonaracode.digibookycarbonara.members;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.carbonaracode.digibookycarbonara.Name;
import com.carbonaracode.digibookycarbonara.lending.LentBook;

public class Member extends AbstractMember {
//This member should have a unique INSS (social security number), last name, first name, email, street name, street number,
// postal code and city.

    private final Address address;

    private List<LentBook> lentBookList;

    private Member(MemberBuilder builder) {
        super(builder.inss, builder.name, builder.email);
        address = builder.address;
        lentBookList = new ArrayList<>();
    }

    public static MemberBuilder newBuilder() {
        return new MemberBuilder();
    }

    public void addLentBook(LentBook lentBook) {
        lentBookList.add(lentBook);
    }

    public void returnLentBook(LentBook lentBook) {
        lentBookList.remove(lentBook);
    }


    public List<LentBook> getLentBookList() {
        return lentBookList;
    }

    public Address getAddress() {
        return this.address;
    }


    public static final class MemberBuilder {
        private String inss;
        private Name name;
        private String email;
        private Address address;

        private MemberBuilder() {
        }

        public MemberBuilder withInss(String inss) {
            validateInss(inss);
            this.inss = inss;
            return this;
        }

        public MemberBuilder withName(Name name) {
            this.name = name;
            return this;
        }

        public MemberBuilder withEmail(String email) {
            validateEmail(email);
            this.email = email;
            return this;
        }

        public MemberBuilder withAddress(Address address) {
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

