package com.carbonaracode.digibookycarbonara.members;

import com.carbonaracode.digibookycarbonara.books.Book;
import com.carbonaracode.digibookycarbonara.books.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MemberRepositoryTest {
    Member bob = new Member("1", new Name("Bob", "Builder"),
            "bob.builder@building.build",
            new Address("Buildstreet", 1, 1, "Buildtown"));

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

        Member hal = new Member("1", new Name("Hal", "Computer"),
                "hal.computer@hal.computer",
                new Address("Computerstreet", 2, 2, "Compiler City"));
        //When

        //Then
        assertThrows(IllegalArgumentException.class, ()->memberRepository.register(hal));
    }

    @Test
    void given2MembersAndAMap_whenRegisteringMemberEmailIsAlreadyInMap_thenThrowsIllegalArgumentException() {
        //Given
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.register(bob);

        Member hal = new Member("2", new Name("Hal", "Computer"),
                "bob.builder@building.build",
                new Address("Computerstreet", 2, 2, "Compiler City"));
        //When

        //Then
        assertThrows(IllegalArgumentException.class, ()->memberRepository.register(hal));
    }

}
