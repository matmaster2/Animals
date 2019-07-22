package com.animals.basic;

import com.animals.enums.DogVoices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.animals.enums.DogVoices.*;

public class Dog implements Animal {

    private static final Logger log = LogManager.getLogger(Dog.class);

    private static final int WALK_SPEED = 20;

    private final String name;
    private int energy = 0;

    public Dog(String name) {
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
        String voices = "";
        if (energy < -10) {
            voices = EXHAUSTED.getVoice();
        } else if (energy < 0) {
            voices = TIRED.getVoice();
        } else if (energy < 10) {
            voices = NORMAL.getVoice();
        } else if (energy < 20) {
            voices = HALF_RESTED.getVoice();
        } else {
            voices = RESTED.getVoice();
        }
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


