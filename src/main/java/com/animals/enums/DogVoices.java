package com.animals.enums;

public enum DogVoices {
    RESTED("HAUUU! I AM RESTED!"),
    HALF_RESTED("HAUU! I AM HALF_RESTED!"),
    NORMAL("normal Hau!"),
    TIRED("Hau...ziew"),
    EXHAUSTED("zzz");

    private final String voice;

    DogVoices(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }
}