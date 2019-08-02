package com.animals.basic;

import static com.animals.enums.DogVoices.*;

import com.animals.enums.DogVoices;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String getName() { return name; }

    @Override
    public boolean isRested() {
        return energy >= 0;
    }

    public DogVoices howRested() {
        if (energy < -10) {
            return EXHAUSTED;
        } else if (energy < 0) {
            return TIRED;
        } else if (energy < 10) {
            return NORMAL;
        } else if (energy < 20) {
            return HALF_RESTED;
        } else {
            return RESTED;
        }
    }
    @Override
    public void sleep(int minutes) {
        this.energy = this.energy + minutes / 2;
    }

    public void sleep(int hour, int minutes) { sleep(minutes + hour * 60); }

    public String makeVoice() {
        String voices = howRested().getVoice();
        log.info(voices);
        this.energy--;
        return voices;
    }

    @Override
    public String makeVoice(int numberOfVoices) {
        StringBuilder manyVoices = new StringBuilder();
        for (int i = 0; i < numberOfVoices; i++) {
            manyVoices.append(makeVoice()).append(" ");
        }
        return manyVoices.toString();
    }

    @Override
    public void walkInMinutes(int minutes) {
        this.energy = this.energy - minutes;
    }

    public void walkInMeters(int meteres) {
        this.energy = this.energy - meteres / WALK_SPEED;
    }
}


