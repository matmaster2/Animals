package com.animals.animals;

import com.animals.enums.DolphinVoices;

import static com.animals.enums.DolphinVoices.*;

public class Dolphin extends Animal{


    public Dolphin(String name, int weight, int moveSpeed) {
        super(name, weight, moveSpeed);
    }

    public DolphinVoices howRested() {
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
