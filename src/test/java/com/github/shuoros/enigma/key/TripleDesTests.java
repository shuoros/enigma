package com.github.shuoros.enigma.key;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripleDesTests {

    @Test
    public void decryptMustReturnTheEncryptedText() throws Exception {
        // Arrange
        String text = "Hello World!";

        // Act
        TripleDes tripleDes = new TripleDes();
        String encryptedText = tripleDes.encrypt(text);
        String decryptedText = tripleDes.decrypt(encryptedText);

        // Assert
        assertEquals(text, decryptedText);
    }

}
