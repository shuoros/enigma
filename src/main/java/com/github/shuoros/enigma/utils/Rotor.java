package com.github.shuoros.enigma.utils;

import com.github.shuoros.enigma.key.Alphabets;
import com.github.shuoros.enigma.key.Languages;

public class Rotor {


    private final char[] rotor;
    private int position;


    public Rotor(Languages language) {
        this(Shuffler.shuffle(Alphabets.get(language)));
    }

    public Rotor(char[] rotor) {
        this.rotor = rotor;
        this.position = 0;
    }

    public char[] me() {
        return rotor;
    }

    public int index() {
        return position;
    }

    public void setIndex(int position) {
        this.position = position;
    }

}
