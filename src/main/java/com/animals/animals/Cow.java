package com.animals.animals;

import com.animals.enums.CowVoices;
import static com.animals.enums.CowVoices.*;

public class Cow extends Animal {

    public Cow(String name, int weight, int walkSpeed) {
        super(name, weight, walkSpeed);
    }

    public CowVoices howRested() {
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


