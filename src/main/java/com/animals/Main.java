package com.animals;

import com.animals.enums.AnimalSpecies;
import com.animals.tasks.AnimalBehaviorSimulator;
import com.animals.tasks.AnimalCreator;

import static com.animals.enums.AnimalSpecies.*;


public class Main {

    public static void main(String[] args) {

        new AnimalBehaviorSimulator.Builder()
                .addAnimal(AnimalCreator.getAnimal(CAT))
                .addRandomAnimals(1)
                .setNumberOfDays(1)
                .build()
                .simulateDaysOfAnimals();

        // System.out.println(AnimalVoiceFactory.getVoice(AnimalSpecies.SKINNY_CAT));

    }
}
