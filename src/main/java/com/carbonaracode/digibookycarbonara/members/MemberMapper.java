package com.carbonaracode.digibookycarbonara.members;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MemberMapper {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    MemberDto memberToMemberDto(Member member){
        return new MemberDto(member.getInss(), member.getName(), member.getEmail(), member.getAddress());
    }

    Member memberDtoToMember(MemberDto memberDto){
        return new Member(memberDto.getInss(), memberDto.getName(), memberDto.getEmail(), memberDto.getAddress());
    }
}
