package com.github.shuoros.enigma.utils;

import com.github.shuoros.enigma.alphabet.Alphabets;
import com.github.shuoros.enigma.alphabet.Languages;

public class Reflector {

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

    public char reflect(char letter) {
        int index = find(letter);
        return reflector[reflector.length - index - 1];
    }

    private int find(char letter) {
        for (int i = 0; i < this.reflector.length; i++) {
            if (letter == this.reflector[i]) {
                return i;
            }
        }
        return -1;
    }

}
