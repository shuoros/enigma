package com.github.shuoros.enigma.utils;

import com.github.shuoros.enigma.key.Languages;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RotorTests {

    @Test
    public void alphabetMustBeShuffledOnRotorsCreation() {
        // Given
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // When
        Rotor rotor = new Rotor(Languages.ENGLISH);

        // Then
        assertNotEquals(alphabet, rotor.me());
    }

    @Test
    public void indexOfRotorMustBe0WhenRotorIsCreated() {
        // Given
        Rotor rotor = new Rotor(Languages.ENGLISH);

        // When
        int index = rotor.index();

        // Then
        assertEquals(0, index);
    }

    @Test
    public void indexMustBeSetInDesiredPositionCorrectly() {
        // Given
        Rotor rotor = new Rotor(Languages.ENGLISH);
        int desiredLocation = 5;

        // When
        rotor.setIndex(desiredLocation);

        // Then
        assertEquals(desiredLocation, rotor.index());
    }

}
