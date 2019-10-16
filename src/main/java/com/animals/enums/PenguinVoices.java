package com.animals.enums;

public enum PenguinVoices implements Voices {
    RESTED("PIU PIU PIU! I AM RESTED!"),
    HALF_RESTED("Piu Piu! I AM HALF_RESTED!"),
    NORMAL("normal Piu!"),
    TIRED("Pi...ziew"),
    EXHAUSTED("zzz");

    private final String voice;

    PenguinVoices(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }


}
