package com.animals.animals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Animal {

    protected final Logger log = LogManager.getLogger(getClass());

    protected final int walkSpeed;
    protected final String name;
    protected final int weight;
    protected int energy = 0;

    Animal(String name, int weight, int walkSpeed) {
        this.weight = weight;
        this.name = name;
        this.walkSpeed = walkSpeed;
    }

    public String getName() {
        return name;
    }

    public boolean isRested() {
        return energy >= 0;
    }

    public void sleep(int minutes) {
        this.energy = this.energy + minutes / 2;
    }

    public void sleep(int hour, int minutes) {
        sleep(minutes + hour * 60);
    }

    public abstract String makeVoice(int numberOfVoices);

    public void walkInMinutes(int minutes) {
        this.energy = this.energy - minutes;
    }

    public void walkInMeters(int meters) {
        this.energy = this.energy - meters / walkSpeed;
    }


}


//todo dodaj sowe - zastanow sie !!! (  ;)  )