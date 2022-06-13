package com.carbonaracode.digibookycarbonara.members;

import com.carbonaracode.digibookycarbonara.security.KeycloakService;
import com.carbonaracode.digibookycarbonara.security.KeycloakUserDTO;
import com.carbonaracode.digibookycarbonara.security.Role;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MemberService {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    MemberMapper memberMapper;
    MemberRepository memberRepository;
    KeycloakService keycloakService;

    public MemberService(MemberMapper memberMapper, MemberRepository memberRepository, KeycloakService keycloakService) {
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
        this.keycloakService = keycloakService;
    }

    public void registerNewMember(MemberDTO memberDto) {
        Member member = this.memberMapper.memberDtoToMember(memberDto);
        this.memberRepository.register(member);
        keycloakService.addUser(new KeycloakUserDTO(memberDto.getName().getLastName(),memberDto.getEmail(), Role.MEMBER));
    }
}
