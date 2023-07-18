package com.github.shuoros.enigma.utils;

public class Shuffler {

    public static char[] shuffle(char[] array){
        char[] shuffled = array.clone();
        for (int i = shuffled.length - 1; i > 0; i--) {
            int index = (int) (Math.random() * (i + 1));
            char temp = shuffled[index];
            shuffled[index] = shuffled[i];
            shuffled[i] = temp;
        }
        return shuffled;
    }

}
