package com.github.shuoros.enigma;

import com.github.shuoros.enigma.alphabet.Languages;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EnigmaTests {

    private static final char[] plain = "سلام دنیا.".toCharArray();
    private static char[] cipher;

    @Test
    @Order(1)
    public void initMustGenerateAnEnigmaKey() {
        // When
        Enigma.init(Languages.PERSIAN, 3);

        // Then
        assertTrue(new File("key.enigma").exists());
    }

    @Test
    @Order(2)
    public void encryptMustGenerateCipherWithTheGivenPlainWithSameSizeOfPlain() {
        // When
        Enigma enigma = new Enigma("key.enigma");
        cipher = enigma.encrypt(plain);

        // Then
        assertEquals(plain.length, cipher.length);
    }

    @Test
    @Order(3)
    public void reEncryptOfTheEncryptedPlainMustReturnTheSamePlain() {
        // When
        Enigma enigma = new Enigma("key.enigma");
        char[] reEncrypted = enigma.encrypt(cipher);

        // Then
        assertArrayEquals(plain, reEncrypted);
    }


}
