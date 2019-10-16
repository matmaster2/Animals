package com.animals.enums;

public enum CatVoices implements Voices {
    RESTED("MIAUUUU! I AM RESTED!"),
    HALF_RESTED("MIAUU! I AM HALF_RESTED!"),
    NORMAL("normal Miau!"),
    TIRED("Miau...ziew"),
    EXHAUSTED("zzz");

    private final String voice;

    CatVoices(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }
}