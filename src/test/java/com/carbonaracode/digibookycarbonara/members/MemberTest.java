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
}
