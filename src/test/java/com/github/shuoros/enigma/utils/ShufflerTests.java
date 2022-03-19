package com.github.shuoros.enigma.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShufflerTests {

    @Test
    public void shuffleMustShuffleTheAlphabet() {
        // Given
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // When
        char[] shuffled = Shuffler.shuffle(Rotor.ALPHABET);

        // Then
        assertNotEquals(alphabet, shuffled);
    }

}
