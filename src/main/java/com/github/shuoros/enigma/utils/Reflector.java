package com.github.shuoros.enigma.utils;

import com.github.shuoros.enigma.key.Alphabets;
import com.github.shuoros.enigma.key.Languages;

public class Reflector {

    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private char[] reflector;

    public Reflector(Languages language) {
        this(Shuffler.shuffle(Alphabets.get(language)));
    }

    public Reflector(char[] reflector) {
        this.reflector = reflector;
    }

    public char[] me() {
        return reflector;
    }

    public void setReflector(char[] reflector) {
        this.reflector = reflector;
    }

    public char reflect(char letter) {
        int index = find(letter);
        return reflector[reflector.length - index - 1];
    }

    public int find(char letter) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (letter == ALPHABET[i]) {
                return i;
            }
        }
        return -1;
    }

}
