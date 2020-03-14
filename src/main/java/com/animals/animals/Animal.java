package com.animals.animals;


import com.animals.enums.AnimalSpecies;
import com.animals.enums.RestLevel;
import com.animals.model.AnimalVoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.animals.enums.RestLevel.*;

public class Animal {

    protected final Logger log = LogManager.getLogger(getClass());

    protected final int moveSpeed;
    protected final String name;
    protected final int weight;
    protected final int growth;
    protected final AnimalVoice animalVoice;
    protected final AnimalSpecies animalSpecies;
    protected int energy = 0;

    private Animal(String name, int weight, int growth, int moveSpeed, AnimalVoice animalVoice, AnimalSpecies animalSpecies) {
        this.weight = weight;
        this.name = name;
        this.moveSpeed = moveSpeed;
        this.animalVoice = animalVoice;
        this.animalSpecies = animalSpecies;
        this.growth = growth;
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
                return animalVoice.getExhausted();
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

    public AnimalSpecies getTypeOfAnimalSpieces() {
        return animalSpecies;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + getName() + '\'' +
                ", type='" + this.getClass().getSimpleName() + '\'' +
                ", spieces:" + getTypeOfAnimalSpieces() +
                '}';
    }

    public static class Builder {
        private String name;
        private int weight;
        private int growth;
        private int moveSpeed;
        AnimalVoice animalVoice;
        AnimalSpecies animalSpecies;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder setGrowth(int growth) {
            this.growth = growth;
            return this;
        }

        public Builder setMoveSpeed(int moveSpeed) {
            this.moveSpeed = moveSpeed;
            return this;
        }

        public Builder setAnimalVoice(AnimalVoice animalVoice) {
            this.animalVoice = animalVoice;
            return this;
        }

        public Builder setAnimalSpecies(AnimalSpecies animalSpecies) {
            this.animalSpecies = animalSpecies;
            return this;
        }

        public Builder() {
        }

        public Animal build() {
            return new Animal(name, weight, growth, moveSpeed, animalVoice, animalSpecies);
        }
    }


}
