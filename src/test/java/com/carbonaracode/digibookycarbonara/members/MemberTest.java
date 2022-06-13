package com.carbonaracode.digibookycarbonara.members;

import com.carbonaracode.digibookycarbonara.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberTest {
    @Test
    void givenAWrongEmailAddress_whenCreatingAMember_thenThrowsIllegalArgumentException() {
        //Given

        //When

        //Then
        assertThrows(IllegalArgumentException.class, ()-> Member.newBuilder()
                .withInss("1")
                .withName(new Name("Pablo", "Ijscobar"))
                .withEmail("ok")
                .withAddress(new Address("snowstreet", 1, 1 , "OkayCity"))
                .build());

    }
    @Test
    void givenANullEmailAddress_whenCreatingAMember_thenThrowsIllegalArgumentException() {
        //Given

        //When

        //Then
        assertThrows(IllegalArgumentException.class, ()-> Member.newBuilder()
                .withInss("1")
                .withName(new Name("Pablo", "Ijscobar"))
                .withEmail(null)
                .withAddress(new Address("snowstreet", 1, 1 , "OkayCity"))
                .build());

    }

    @Test
    void givenAnEmailAdress_whenCreatingAMember_ThenEverythingIsOk() {
        //Given
        String email = "pablo@ijscobar.com";
        //When
        Member bob = Member.newBuilder()
                .withInss("1")
                .withName(new Name("Pablo", "Ijscobar"))
                .withEmail("pablo@ijscobar.com")
                .withAddress(new Address("snowstreet", 1, 1 , "OkayCity"))
                .build();

        //Then
        assertEquals(bob.getEmail(), email);
    }

    @Test
    void givenAnInss_whenCreatingAMember_ThenEverythingIsOk() {
        //Given
        String inss = "1";
        //When
        Member member = Member.newBuilder()
                .withInss(inss)
                .withName(new Name("Pablo", "Ijscobar"))
                .withEmail("pablo@ijscobar.com")
                .withAddress(new Address("snowstreet", 1, 1 , "OkayCity"))
                .build();
        //Then
        assertEquals(member.getInss(), inss);

    }

    @Test
    void givenABlankInss_whenCreatingAMember_ThenThrowsIllegalArgumentException() {
        //Given
        String inss = "";
        //When

        //Then
        assertThrows(IllegalArgumentException.class, ()-> Member.newBuilder()
                .withInss(inss)
                .withName(new Name("Pablo", "Ijscobar"))
                .withEmail(null)
                .withAddress(new Address("snowstreet", 1, 1 , "OkayCity"))
                .build());

    }

    @Test
    void givenANullInss_whenCreatingAMember_ThenThrowsIllegalArgumentException() {
        //Given
        String inss = null;
        //When

        //Then
        assertThrows(IllegalArgumentException.class, () -> Member.newBuilder()
                .withInss(inss)
                .withName(new Name("Pablo", "Ijscobar"))
                .withEmail(null)
                .withAddress(new Address("snowstreet", 1, 1 , "OkayCity"))
                .build());
    }
}
