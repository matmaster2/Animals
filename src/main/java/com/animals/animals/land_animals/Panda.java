package com.animals.animals.land_animals;

import com.animals.animals.Animal;
import com.animals.enums.PandaVoices;

import static com.animals.enums.PandaVoices.*;

public class Panda extends LandAnimal {

    public Panda(String name, int weight, int moveSpeed) {
        super(name, weight, moveSpeed);
    }

    public PandaVoices howRested() {
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
}