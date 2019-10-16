package com.animals.animals;

import com.animals.enums.CatVoices;

import static com.animals.enums.CatVoices.*;

public class Cat extends Animal {

    public Cat(String name, int weight, int walkSpeed) {
        super(name, weight, walkSpeed);
    }

    public CatVoices howRested() {
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


