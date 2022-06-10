package com.carbonaracode.digibookycarbonara.members;

import com.carbonaracode.digibookycarbonara.Name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberDTO extends AbstractMemberDTO{
    private final Address address;

    public MemberDTO(String inss, Name name, String email, Address address) {
        super(inss, name, email);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

