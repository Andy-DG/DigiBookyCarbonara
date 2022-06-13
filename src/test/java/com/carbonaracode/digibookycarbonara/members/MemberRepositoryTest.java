package com.carbonaracode.digibookycarbonara.members;

import com.carbonaracode.digibookycarbonara.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberRepositoryTest {

    Member bob = Member.newBuilder()
            .withInss(UUID.randomUUID().toString())
            .withName(new Name("Bob", "Builder"))
            .withEmail("bob.builder@building.build")
            .withAddress(new Address("Buildstreet", 1, 1, "Buildtown"))
            .build();



    @Test
    @DisplayName("Given a map of members, when we register a member, then the member is stored in the map")
    void givenAMapOfMembers_whenWeRegisterAMember_thenTheMemberIsStoredInTheMap() {
        //Given
        MemberRepository memberRepository = new MemberRepository();
        //when
        memberRepository.register(bob);
        //then

        Assertions.assertTrue(memberRepository.getMemberMap().containsValue(bob));
    }

    @Test
    void givenAMemmberAndAMap_whenRegisteringMemberEqualsNull_thenThrowsIllegalArgumentException() {
        //Given
        MemberRepository memberRepository = new MemberRepository();

        Member member = null;
        //When

        //Then
        assertThrows(IllegalArgumentException.class, ()->memberRepository.register(member));
    }

    @Test
    void given2MembersAndAMap_whenRegisteringMemberInssIsAlreadyInMap_thenThrowsIllegalArgumentException() {
        //Given
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.register(bob);


        Member hal = Member.newBuilder()
                .withInss("1")
                .withName(new Name("Hal", "Computer"))
                .withEmail("hal.computer@hal.co.uk")
                .withAddress(new Address("Computerstreet", 2, 2, "Compiler City"))
                .build();
        //When

        //Then
        assertThrows(IllegalArgumentException.class, ()->memberRepository.register(hal));
    }

    @Test
    void given2MembersAndAMap_whenRegisteringMemberEmailIsAlreadyInMap_thenThrowsIllegalArgumentException() {
        //Given
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.register(bob);

        Member hal = Member.newBuilder()
                .withInss("2")
                .withName(new Name("Hal", "Computer"))
                .withEmail("bob.builder@building.build")
                .withAddress(new Address("Computerstreet", 2, 2, "Compiler City"))
                .build();
        //When

        //Then
        assertThrows(IllegalArgumentException.class, ()->memberRepository.register(hal));
    }

}
