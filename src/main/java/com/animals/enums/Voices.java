package com.animals.enums;

public interface Voices {

    String voice=null;

    default String getVoice() {
        return voice;
    }
}
