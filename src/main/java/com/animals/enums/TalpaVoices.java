package com.animals.enums;

public enum TalpaVoices implements Voices {
    RESTED("KOPKOPKOP! I AM RESTED!"),
    HALF_RESTED("KOPKOP! I AM HALF_RESTED!"),
    NORMAL("KOP normal!"),
    TIRED("KOP...ziew"),
    EXHAUSTED("zzz");

    private final String voice;

    TalpaVoices(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }
}