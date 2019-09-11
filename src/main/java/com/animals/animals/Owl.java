package com.animals.animals;

import com.animals.enums.OwlVoices;

import static com.animals.enums.OwlVoices.*;

public class Owl extends Animal {
    public Owl(String name, int weight, int walkSpeed) {
        super(name, weight, walkSpeed);
    }

    public OwlVoices howRested() {
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
        return voices;//todo powtarza sie a nie powinno :(
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
