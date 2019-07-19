package com.animals.basic;

public interface Animal {

    String getName();

    boolean isRested();

    String makeVoice(int numberOfVoices);

    void walkInMinutes(int minutes);

    void sleep(int minutes);
}
