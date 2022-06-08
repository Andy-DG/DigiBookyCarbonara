package com.carbonaracode.digibookycarbonara.members;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MemberService {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    MemberMapper memberMapper;
    MemberRepository memberRepository;

    public MemberService(MemberMapper memberMapper, MemberRepository memberRepository) {
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
    }

    public void registerNewMember(MemberDTO memberDto) {
        Member member = this.memberMapper.memberDtoToMember(memberDto);
        this.memberRepository.register(member);
    }
}
