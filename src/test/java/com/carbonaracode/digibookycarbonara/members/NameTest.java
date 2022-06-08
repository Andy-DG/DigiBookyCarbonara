package com.carbonaracode.digibookycarbonara.members;

import com.carbonaracode.digibookycarbonara.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @Test
    void givenALastName_whenCreatingName_thenLastNameIsNotEmpty() {
        //Given
        String lastName = "Builder";
        //When
        Name name = new Name("Bob", lastName);

        //Then
        assertEquals(lastName,name.getLastName());
    }

    @Test
    void givenALastNameThatIsBlank_whenCreatingName_thenIllegalArgumentException() {
        //Given
        String lastName = "";
        //When


        //Then
        assertThrows(IllegalArgumentException.class, ()-> new Name("Bob", lastName));
    }

    @Test
    void givenALastNameThatIsNull_whenCreatingName_thenIllegalArgumentException() {
        //Given
        String lastName = null;
        //When


        //Then
        assertThrows(IllegalArgumentException.class, ()-> new Name("Bob", lastName));
    }
}
