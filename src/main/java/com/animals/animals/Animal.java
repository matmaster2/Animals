package com.animals.animals;


import com.animals.enums.RestLevel;
import com.animals.enums.TypeOfAnimal;
import com.animals.factory.AnimalVoiceFactory;
import com.animals.model.AnimalVoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.animals.enums.RestLevel.*;

public abstract class Animal {

    protected final Logger log = LogManager.getLogger(getClass());

    protected final int moveSpeed;
    protected final String name;
    protected final int weight;
    protected final AnimalVoice animalVoice;
    protected int energy = 0;

    public Animal(String name, int weight, int moveSpeed, AnimalVoice animalVoice) {
        this.weight = weight;
        this.name = name;
        this.moveSpeed = moveSpeed;
        this.animalVoice = animalVoice;
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

    public RestLevel howRested() {
        if (energy < -10) {
            return EXHAUSTED;
        } else if (energy < 0) {
            return TIRED;
        } else if (energy < 10) {
            return NORMAL;
        } else {
            return RESTED;
        }
    }

    public String makeVoice() {
        RestLevel restLevel = howRested();
        this.energy--;
        switch (restLevel) {
            case EXHAUSTED:
                return animalVoice.getExhausted(); //todo ma zwrocic poprawny glos w zaleznosci od zwierzecia
            case TIRED:
                return animalVoice.getTired();
            case NORMAL:
                return animalVoice.getNormal();
            case RESTED:
                return animalVoice.getRested();
            default:
                return null;
        }
    }

    public String makeVoice(int numberOfVoices) {
        StringBuilder manyVoices = new StringBuilder();
        for (int i = 0; i < numberOfVoices; i++) {
            String voice = makeVoice();
            log.info(voice);
            manyVoices.append(voice).append(" ");
        }
        return manyVoices.toString();
    }

    public void moveInMinutes(int minutes) {
        this.energy = this.energy - minutes;
    }

    public void moveInMeters(int meters) {
        this.energy = this.energy - meters / moveSpeed;
    }

    public TypeOfAnimal getTypeOfAnimal() {
        return TypeOfAnimal.valueOf(this.getClass().getSimpleName().toUpperCase());
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + this.getClass() + '\'' +
                '}';
    }
}
