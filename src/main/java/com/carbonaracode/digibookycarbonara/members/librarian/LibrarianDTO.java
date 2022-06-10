package com.carbonaracode.digibookycarbonara.members.librarian;

import com.carbonaracode.digibookycarbonara.Name;
import com.carbonaracode.digibookycarbonara.members.AbstractMemberDTO;
import com.carbonaracode.digibookycarbonara.members.Address;
import com.carbonaracode.digibookycarbonara.members.MemberDTO;

public class LibrarianDTO extends AbstractMemberDTO {

    public LibrarianDTO(String inss, Name name, String email) {
        super(inss, name, email);
    }
}
