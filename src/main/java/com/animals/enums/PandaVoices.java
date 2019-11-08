package com.animals.enums;

public enum PandaVoices implements Voices {
    RESTED("WRAWWWWWWWW! I AM RESTED"),
    HALF_RESTED("WRAWW! I AM HALF_RESTED!"),
    NORMAL("normal Wraw!"),
    TIRED("Wraw...ziew"),
    EXHAUSTED("zzz");

    private final String voice;

    PandaVoices(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }
}