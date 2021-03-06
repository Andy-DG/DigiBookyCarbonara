package com.carbonaracode.digibookycarbonara.members;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MemberMapper {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    MemberDTO memberToMemberDto(Member member){
        return new MemberDTO(member.getInss(), member.getName(), member.getEmail(), member.getAddress());
    }

    Member memberDtoToMember(MemberDTO memberDto){
        return Member.newBuilder()
                .withInss(memberDto.getInss())
                .withEmail(memberDto.getEmail())
                .withName(memberDto.getName())
                .withAddress(memberDto.getAddress())
                .build();
    }
}
