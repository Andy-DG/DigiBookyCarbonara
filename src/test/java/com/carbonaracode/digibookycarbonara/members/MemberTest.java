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

    @Test
    void givenAnInss_whenCreatingAMember_ThenEverythingIsOk() {
        //Given
        String inss = "1";
        //When
        Member bob = new Member(inss, new Name("Bob", "Builder"),
                "bob.builder@building.build",
                new Address("Buildstreet", 1, 1, "Buildtown"));
        //Then
        assertEquals(bob.getInss(), inss);

    }

    @Test
    void givenABlankInss_whenCreatingAMember_ThenThrowsIllegalArgumentException() {
        //Given
        String inss = "";
        //When

        //Then
        assertThrows(IllegalArgumentException.class, ()-> new Member(inss, new Name("Bob", "Builder"),
                "bob.builder@building.build",
                new Address("Buildstreet", 1, 1, "Buildtown")));

    }

    @Test
    void givenANullInss_whenCreatingAMember_ThenThrowsIllegalArgumentException() {
        //Given
        String inss = null;
        //When

        //Then
        assertThrows(IllegalArgumentException.class, ()-> new Member(inss, new Name("Bob", "Builder"),
                "bob.builder@building.build",
                new Address("Buildstreet", 1, 1, "Buildtown")));

    }
}
