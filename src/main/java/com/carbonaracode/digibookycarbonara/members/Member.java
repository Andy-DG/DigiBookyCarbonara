package com.carbonaracode.digibookycarbonara.members;


import com.carbonaracode.digibookycarbonara.Name;
import com.carbonaracode.digibookycarbonara.lending.LentBook;

import java.util.ArrayList;
import java.util.List;

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
            this.inss = inss;
            return this;
        }

        public MemberBuilder withName(Name name) {
            this.name = name;
            return this;
        }

        public MemberBuilder withEmail(String email) {
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

    }
}

