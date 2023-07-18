package com.github.shuoros.enigma.alphabet;

import java.util.Map;

import static java.util.Map.entry;

public class Alphabets {

    public static final Map<Languages, String> lang = Map.ofEntries(//
            entry(Languages.PERSIAN, "ابپتثجچحخدذرزژسشصضطظعغفقکگلمنوهی .,;:!?'\"()"),//
            entry(Languages.ENGLISH, "abcdefghijklmnopqrstuvwxyz .,;:!?'\"()"),
            entry(Languages.GERMAN, "abcdefghijklmnopqrstuvwxyzäöüß .,;:!?'\"()"));//

    public static char[] get(Languages language) {
        return lang.get(language).toCharArray();
    }
}
