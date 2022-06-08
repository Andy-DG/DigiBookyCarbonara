package com.carbonaracode.digibookycarbonara.members;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("member")
@CrossOrigin("http:localhost:4200")
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
