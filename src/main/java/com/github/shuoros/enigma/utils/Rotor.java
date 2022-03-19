package com.github.shuoros.enigma.utils;

public class Rotor {

    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private final char[] rotor;
    private int position;

    public static char[] shuffle(){
        char[] shuffled = alphabet.clone();
        for (int i = shuffled.length - 1; i > 0; i--) {
            int index = (int) (Math.random() * (i + 1));
            char temp = shuffled[index];
            shuffled[index] = shuffled[i];
            shuffled[i] = temp;
        }
        return shuffled;
    }

    public Rotor(){
        this(shuffle());
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
