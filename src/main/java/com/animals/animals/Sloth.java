package com.animals.animals;

import com.animals.enums.SlothVoices;

import static com.animals.enums.SlothVoices.*;

public class Sloth extends Animal {


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
