package com.animals;

public class Cat {

    private static final String VOICE = "Miau!!";
    private static final int WALK_SPEED = 20;

    private int energy = 0;

    public boolean isRested() {
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

    void walkInMinutes(int minutes) {
        this.energy = this.energy - minutes;
    }

    void walkInMeters(int meteres) {
        this.energy = this.energy - meteres / WALK_SPEED;
    }
}


