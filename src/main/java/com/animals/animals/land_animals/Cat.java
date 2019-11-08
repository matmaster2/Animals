package com.animals.animals.land_animals;

import com.animals.animals.Animal;
import com.animals.enums.CatVoices;

import static com.animals.enums.CatVoices.*;

public class Cat extends LandAnimal {

    public Cat(String name, int weight, int moveSpeed) {
        super(name, weight, moveSpeed);
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


