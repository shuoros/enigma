package com.github.shuoros.enigma.utils;

import com.github.shuoros.enigma.key.Alphabets;
import com.github.shuoros.enigma.key.Languages;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShufflerTests {

    @Test
    public void shuffleMustShuffleTheAlphabet() {
        // Given
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // When
        char[] shuffled = Shuffler.shuffle(Alphabets.get(Languages.ENGLISH));

        // Then
        assertNotEquals(alphabet, shuffled);
    }

}
