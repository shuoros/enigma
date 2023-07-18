package com.github.shuoros.enigma.utils;

import com.github.shuoros.enigma.alphabet.Alphabets;
import com.github.shuoros.enigma.alphabet.Languages;

public class Rotor {

    private final Languages language;
    private char[] rotor;


    public Rotor(Languages language) {
        this(Shuffler.shuffle(Alphabets.get(language)), language);
    }

    public Rotor(char[] rotor, Languages language) {
        this.language = language;
        this.rotor = rotor;
    }

    public char[] me() {
        return rotor;
    }

    public int size() {
        return rotor.length;
    }

    public void shift(){
        char[] temp = new char[this.rotor.length];
        System.arraycopy(this.rotor, 1, temp, 0, this.rotor.length - 1);
        temp[this.rotor.length - 1] = this.rotor[0];
        this.rotor = temp;
    }

    public char rotate(char input) {
        int index = find(input);
        return this.rotor[index];
    }

    public char reverseRotate(char input) {
        int index = findReverse(input);
        return Alphabets.get(this.language)[index];
    }

    private int find(char letter) {
        for (int i = 0; i < Alphabets.get(this.language).length; i++) {
            if (letter == Alphabets.get(this.language)[i]) {
                return i;
            }
        }
        return -1;
    }

    private int findReverse(char letter) {
        for (int i = 0; i < this.rotor.length; i++) {
            if (letter == this.rotor[i]) {
                return i;
            }
        }
        return -1;
    }

}
