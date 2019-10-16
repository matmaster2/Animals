package com.animals.animals;

import com.animals.enums.PenguinVoices;

import static com.animals.enums.PenguinVoices.*;

public class Penguin extends Animal {


    public Penguin(String name, int weight, int moveSpeed) {
        super(name, weight, moveSpeed);
    }

    public PenguinVoices howRested() {
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
