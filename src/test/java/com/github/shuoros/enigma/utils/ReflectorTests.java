package com.github.shuoros.enigma.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ReflectorTests {

    @Test
    public void alphabetMustBeShuffledOnReflectorsCreation() {
        // Given
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // When
        Reflector reflector = new Reflector();

        // Then
        assertNotEquals(alphabet, reflector.me());
    }

    @Test
    public void findMustFindTheGivenCharsIndexCorrectly(){
        // Given
        char[] reflectorSequence = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // When
        Reflector reflector = new Reflector(reflectorSequence);

        // Then
        assertEquals(0, reflector.find('a'));
    }

    @Test
    public void reflectMustReturnTheCorrectIndex(){
        // Given
        char[] reflectorSequence = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // When
        Reflector reflector = new Reflector(reflectorSequence);

        // Then
        assertEquals('z', reflector.reflect('a'));
        assertEquals('x', reflector.reflect('c'));
    }

}
