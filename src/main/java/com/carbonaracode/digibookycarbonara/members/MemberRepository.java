package com.carbonaracode.digibookycarbonara.members;

import com.carbonaracode.digibookycarbonara.Name;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

@Repository
public class MemberRepository {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private Map<String, Member> memberMap;

    public MemberRepository() {
        this.memberMap = createAndInitializeMemberMap();
    }

    public Map<String, Member> createAndInitializeMemberMap() {
        Member member = Member.newBuilder()
                .withInss("1")
                .withName(new Name("Pablo", "Ijscobar"))
                .withEmail("jurgen@jurgen.jurgen")
                .withAddress(new Address("snowstreet", 1, 1 , "OkayCity"))
                .build();
        memberMap = new HashMap<>();
        memberMap.put(member.getInss(), member);
        return memberMap;
    }

    public Map<String, Member> getMemberMap() {
        return memberMap;
    }

    public Member getMemberByInss(String inss) {
        isNotNull(inss);
        isNotEmpty(inss);
        doesMemberExist(inss);
        return this.memberMap.get(inss);
    }

    private void doesMemberExist(String inss) {
        if (this.memberMap.get(inss) == null) throw new IllegalArgumentException("This member does not exist");
    }

    public Member register(Member member) throws IllegalArgumentException {
        isNotNull(member);
        validateInss(member);
        validateEmail(member);
        memberMap.put(member.getInss(),member);
        logger.info( member + " is registered.");
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

    private void isNotNull(String inss) {
        if (inss == null) {
            throw new IllegalArgumentException("Inss cannot be null");
        }
    }

    private void isNotEmpty(String inss) {
        if (inss.equals("")) {
            throw new IllegalArgumentException("Inss cannot be empty");
        }
    }
}
