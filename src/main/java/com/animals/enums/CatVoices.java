package com.animals.enums;

public enum CatVoices {
    RESTED("LEGIA!"),
    HALF_RESTED("ARKA_GDYNIA!"),
    NORMAL("Miau!"),
    TIRED("Hau!"),
    EXHAUSTED("Szczek");

    private final String voice;

    CatVoices(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;

    }
}

