package com.animals;

import com.animals.enums.CatVoices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cat {

    private static final Logger log = LogManager.getLogger(Cat.class);

    private static final int WALK_SPEED = 20;

    private final String name;
    private int energy = 0;

    public Cat(String name) {
        this.name = name;
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

    public String makeVoice() {
        String voices = "";
        if (energy < -10) {
            voices = CatVoices.EXHAUSTED.getVoice();
        } else if (energy < 0) {
            voices = CatVoices.TIRED.getVoice();
        } else if (energy < 10) {
            voices = CatVoices.NORMAL.getVoice();
        } else if (energy < 20) {
            voices = CatVoices.HALF_RESTED.getVoice();
        } else {
            voices = CatVoices.RESTED.getVoice();
        }
        //TODO BEDZIE MNIE GNEBIC ZEBY PRZENIESC PRZEDZIALY DO ENUMOW !!
        log.info(voices);
        this.energy--;
        return voices;
    }

    public String makeVoice(int numberOfVoices) {
        StringBuilder manyVoices = new StringBuilder();
        for (int i = 0; i < numberOfVoices; i++) {
            manyVoices.append(makeVoice()).append(" ");
        }
        return manyVoices.toString();
    }

    public void walkInMinutes(int minutes) {
        this.energy = this.energy - minutes;
    }

    public void walkInMeters(int meteres) {
        this.energy = this.energy - meteres / WALK_SPEED;
    }
}


