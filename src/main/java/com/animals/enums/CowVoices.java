package com.animals.enums;

public enum CowVoices implements Voices {
    RESTED("MUUUU! I AM RESTED!"),
    HALF_RESTED("MUU! I AM HALF_RESTED!"),
    NORMAL("normal Muuu!"),
    TIRED("Muuu...ziew"),
    EXHAUSTED("zzz");

    private final String voice;

    CowVoices(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }
}