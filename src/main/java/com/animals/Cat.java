package com.animals;

public class Cat {

    private static final String VOICE = "Miau!!";
    private static final int WALK_SPEED = 20;

    private int energy = 0;

    public boolean isRested() {
        return energy >= 0;
    }

    public void sleep(int minutes) {
        this.energy = this.energy + minutes / 2;
    }

    public void sleep(int hour, int minutes) {
        sleep(minutes + hour * 60);
    }

    public String makeVoice() {
        System.out.println(VOICE);
        this.energy--;
        return VOICE;
    }

    public String makeVoice(int numberOfVoices) {
        StringBuilder manyVoices = new StringBuilder();
        for (int i = 0; i < numberOfVoices; i++) {
            makeVoice();
            manyVoices.append(VOICE).append(" ");
        }
        return manyVoices.toString();
    }

    public void walkInMinutes(int minutes) {
        this.energy = this.energy - minutes;
    }

    public void walkInMeters(int meteres) {
        this.energy = this.energy - meteres / WALK_SPEED;
    }
}


