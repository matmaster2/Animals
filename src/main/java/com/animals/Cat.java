package com.animals;

import com.animals.enums.CatVoices;

import java.util.Arrays;
import java.util.List;

public class Cat {

    private static final int WALK_SPEED = 20;

    private final String name;
    private int energy = 0;

    public Cat(String name){
        this.name=name;
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
        String voices="xd"; //TODO: glosy w zaleznosci od zmeczenia, przedzialy po 10 (normal 0-10)
        //BEDZIE MNIE GNEBIC ZEBY PRZENIESC PRZEDZIALY DO ENUMOW !! chuj
        System.out.println(voices);
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


