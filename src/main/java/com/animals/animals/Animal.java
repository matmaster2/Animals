package com.animals.animals;

import com.animals.enums.Voices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Animal {

    protected final Logger log = LogManager.getLogger(getClass());

    protected final int moveSpeed;
    protected final String name;
    protected final int weight;
    protected int energy = 0;

    public Animal(String name, int weight, int moveSpeed) {
        this.weight = weight;
        this.name = name;
        this.moveSpeed = moveSpeed;
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

    public abstract Voices howRested();

    public String makeVoice() {
        String voices = howRested().getVoice();
        log.info(voices);
        this.energy--;
        return voices;
    }

    public String makeVoice(int numberOfVoices){
        StringBuilder manyVoices = new StringBuilder();
        for (int i = 0; i < numberOfVoices; i++) {
            manyVoices.append(makeVoice()).append(" ");
        }
        return manyVoices.toString();
    }

    public void moveInMinutes(int minutes) {
        this.energy = this.energy - minutes;
    }

    public void moveInMeters(int meters) {
        this.energy = this.energy - meters / moveSpeed;
    }


}
