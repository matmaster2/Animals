package com.animals.enums;

public enum OwlVoices {
    RESTED("HUU HUU HUU! I AM RESTED!"),
    HALF_RESTED("Hu Hu! I AM HALF_RESTED!"),
    NORMAL("normal Hu Hu!"),
    TIRED("Hu...ziew"),
    EXHAUSTED("zzz");

    private final String voice;

    OwlVoices(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }
}
