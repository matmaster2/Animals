package com.animals.animals;

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
}


