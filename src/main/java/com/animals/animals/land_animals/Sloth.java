package com.animals.animals.land_animals;

import com.animals.animals.Animal;
import com.animals.enums.SlothVoices;

import static com.animals.enums.SlothVoices.*;

public class Sloth extends LandAnimal {


    public Sloth(String name, int weight, int moveSpeed) {
        super(name, weight, moveSpeed);
    }

    public SlothVoices howRested() {
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
