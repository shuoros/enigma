package com.github.shuoros.enigma.alphabet;

public enum Languages {

    PERSIAN("fa"),
    ENGLISH("en"),
    FRENCH("fr"),
    GERMAN("de"),
    ITALIAN("it"),
    SPANISH("es"),
    RUSSIAN("ru"),
    PORTUGUESE("pt"),
    CHINESE("zh"),
    JAPANESE("ja"),
    KOREAN("ko"),
    POLISH("pl"),
    DUTCH("nl"),
    SWEDISH("sv"),
    FINNISH("fi"),
    HUNGARIAN("hu"),
    ROMANIAN("ro"),
    TURKISH("tr"),
    CZECH("cs"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    GREEK("el"),
    BULGARIAN("bg"),
    NORWEGIAN("no"),
    DANISH("da"),
    CROATIAN("hr");

    private final String language;

    Languages(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
