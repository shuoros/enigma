package com.github.shuoros.enigma.utils;

public class Reflector {

    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private char[] reflector;

    public Reflector() {
        this(Shuffler.shuffle(ALPHABET));
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
