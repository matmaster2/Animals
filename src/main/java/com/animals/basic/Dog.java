package com.animals.basic;

import com.animals.enums.DogVoices;

import static com.animals.enums.DogVoices.*;

public class Dog extends Animal {

    public Dog(String name, int weight, int walkSpeed) {
        super(name, weight, walkSpeed);
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
}


