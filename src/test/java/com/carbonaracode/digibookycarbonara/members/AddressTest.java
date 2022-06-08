package com.carbonaracode.digibookycarbonara.members;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    @Test
    void givenAnAdress_whenAddingACity_thenEverythingIsOk() {
        //Given
        String city = "Buildtown";
        //When
        Address address = new Address("Buildstreet", 1, 1, city);

        //Then
        assertEquals("Buildtown", address.getCity());
    }

    @Test
    void givenACityThatIsBlank_whenCreatingAddress_thenIllegalArgumentException() {
        //Given
        String city = "";
        //When


        //Then
        assertThrows(IllegalArgumentException.class, ()->  new Address("Buildstreet", 1, 1, city));
    }

    @Test
    void givenACityThatIsNull_whenCreatingAddress_thenIllegalArgumentException() {
        //Given
        String city = null;
        //When


        //Then
        assertThrows(IllegalArgumentException.class, ()->  new Address("Buildstreet", 1, 1, city));
    }
}
