package com.animals.enums;

public enum DolphinVoices implements Voices {
    RESTED("PLUM PLUM PLUM! I AM RESTED!"),
    HALF_RESTED("Plum Plum! I AM HALF_RESTED!"),
    NORMAL("normal Plum!"),
    TIRED("Plu...ziew"),
    EXHAUSTED("zzz");

    private final String voice;

    DolphinVoices(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }
}
