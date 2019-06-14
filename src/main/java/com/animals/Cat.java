package com.animals;

public class Cat {

    private static final String VOICE = "Miau!!";

    private int energy = 0;

    private boolean isRested() {
        return energy >= 0;
    }

    void sleep(int minutes) {
        this.energy = this.energy + minutes / 2;
    }

    void sleep(int hour, int minutes) {
        sleep(minutes + hour * 60);
    }

    String makeVoice() {
        System.out.println(VOICE);
        this.energy--;
        return VOICE;
    }

    String makeVoice(int numberOfVoices) {
        StringBuilder manyVoices = new StringBuilder();
        for (int i = 0; i < numberOfVoices; i++) {
            makeVoice();
            manyVoices.append(VOICE).append(" ");
        }
        return manyVoices.toString();
    }


    void walk(int minutes) {
        this.energy = this.energy - minutes;
    }

}


