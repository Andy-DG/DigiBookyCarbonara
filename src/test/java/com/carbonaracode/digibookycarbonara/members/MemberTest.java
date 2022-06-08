package com.carbonaracode.digibookycarbonara.members;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void givenAWrongEmailAddress_whenCreatingAMember_thenThrowsIllegalArgumentException() {
        //Given

        //When

        //Then
        assertThrows(IllegalArgumentException.class, ()-> new Member("1", new Name("Bob", "Builder"),
                "halloditismijnemailadres",
                new Address("Buildstreet", 1, 1, "Buildtown")));

    }

    @Test
    void givenAnEmailAdress_whenCreatingAMember_ThenEverythingIsOk() {
        //Given
        String email = "bob.builder@building.build";
        //When
        Member bob = new Member("1", new Name("Bob", "Builder"),
                email,
                new Address("Buildstreet", 1, 1, "Buildtown"));

        //Then
        assertEquals(bob.getEmail(), email);
    }
}
