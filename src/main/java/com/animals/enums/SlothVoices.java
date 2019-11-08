package com.animals.enums;

public enum SlothVoices implements Voices {
    RESTED("zzz"),
    HALF_RESTED("zzzzzzzzz"),
    NORMAL("zzzZZzzZzZz"),
    TIRED("ZZZ"),
    EXHAUSTED("ZZZZZZZZZ");

    private final String voice;

    SlothVoices(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }


}
