package com.carbonaracode.digibookycarbonara.members;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MemberRepository {
    private Map<String, Member> memberMap;

    public MemberRepository() {
        this.memberMap = new HashMap<>();
    }

    public Map<String, Member> getMemberMap() {
        return memberMap;
    }

    public Member register(Member member) throws IllegalArgumentException {
        isNotNull(member);
        validateInss(member);
        validateEmail(member);
        memberMap.put(member.getInss(),member);
        return member;
    }

    private void validateEmail(Member member) {
        if (this.memberMap.values().stream().map(Member::getEmail).anyMatch(member1-> Objects.equals(member1, member.getEmail()))){
            throw new IllegalArgumentException("email already in use");
        }
    }

    private void validateInss(Member member) {
        if (this.memberMap.containsKey(member.getInss())){
            throw new IllegalArgumentException("Member already registered!");
        }
    }

    private void isNotNull(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
    }
}
