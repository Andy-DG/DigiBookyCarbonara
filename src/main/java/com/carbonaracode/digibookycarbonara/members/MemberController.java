package com.carbonaracode.digibookycarbonara.members;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public MemberDto registerNewMember(@RequestBody MemberDto memberDto){
        this.memberService.registerNewMember(memberDto);
        return memberDto;
    }
}
