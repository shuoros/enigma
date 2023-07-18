package com.github.shuoros.enigma.utils;

import com.github.shuoros.enigma.alphabet.Languages;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RotorTests {

    @Test
    public void alphabetMustBeShuffledOnRotorsCreation() {
        // Given
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz .,;:!?'\"()".toCharArray();

        // When
        Rotor rotor = new Rotor(Languages.ENGLISH);

        // Then
        assertFalse(Arrays.equals(alphabet, rotor.me()));
    }

    @Test
    public void sizeMustBeSameAsAlphabetLength() {
        // Given
        int expectedSize = "abcdefghijklmnopqrstuvwxyz .,;:!?'\"()".length();

        // When
        Rotor rotor = new Rotor(Languages.ENGLISH);

        // Then
        assertEquals(expectedSize, rotor.size());
    }

    @Test
    public void shiftMustShiftTheRotorOneCharToRight() {
        // Given
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz .,;:!?'\"()".toCharArray();
        char[] shiftedAlphabet = "bcdefghijklmnopqrstuvwxyz .,;:!?'\"()a".toCharArray();

        // When
        Rotor rotor = new Rotor(alphabet, Languages.ENGLISH);
        rotor.shift();

        // Then
        assertArrayEquals(shiftedAlphabet, rotor.me());
    }

    @Test
    public void rotateMustRotateACharInRotorCorrectly(){
        // Given
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz .,;:!?'\"()".toCharArray();
        char[] shuffledAlphabet = "bcdefghijklmnopqrstuvwxyza .,;:!?'\"()a".toCharArray();

        // When
        Rotor rotor = new Rotor(shuffledAlphabet, Languages.ENGLISH);
        char rotatedChar = rotor.rotate(alphabet[0]);

        // Then
        assertEquals(shuffledAlphabet[0], rotatedChar);
    }

    @Test
    public void reverseRotateMustRotateACharInRotorCorrectly(){
        // Given
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz .,;:!?'\"()".toCharArray();
        char[] shuffledAlphabet = "bcdefghijklmnopqrstuvwxyza .,;:!?'\"()a".toCharArray();

        // When
        Rotor rotor = new Rotor(shuffledAlphabet, Languages.ENGLISH);
        char reversedRotatedChar = rotor.reverseRotate(shuffledAlphabet[0]);

        // Then
        assertEquals(alphabet[0], reversedRotatedChar);
    }

}
