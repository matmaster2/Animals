package com.animals.animals;

import com.animals.enums.TalpaVoices;

import static com.animals.enums.TalpaVoices.*;

public class Talpa extends Animal {

    public Talpa(String name, int weight, int walkSpeed) {
        super(name, weight, walkSpeed);
    }

    public TalpaVoices howRested() {
        if (energy < -10) {
            return TalpaVoices.EXHAUSTED;
        } else if (energy < 0) {
            return TalpaVoices.TIRED;
        } else if (energy < 10) {
            return TalpaVoices.NORMAL;
        } else if (energy < 20) {
            return TalpaVoices.HALF_RESTED;
        } else {
            return TalpaVoices.RESTED;
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
