package com.github.shuoros.enigma.utils;

public class Rotor {

    public static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private final char[] rotor;
    private int position;


    public Rotor() {
        this(Shuffler.shuffle(ALPHABET));
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
