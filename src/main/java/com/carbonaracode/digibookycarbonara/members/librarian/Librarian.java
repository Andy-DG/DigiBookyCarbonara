package com.carbonaracode.digibookycarbonara.members.librarian;

import com.carbonaracode.digibookycarbonara.Name;
import com.carbonaracode.digibookycarbonara.lending.LentBook;
import com.carbonaracode.digibookycarbonara.members.AbstractMember;
import com.carbonaracode.digibookycarbonara.members.Address;
import com.carbonaracode.digibookycarbonara.members.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Librarian extends AbstractMember {

    public Librarian(String inss, Name name, String email) {
        super(inss, name, email);
    }


}
