package com.animals;

import com.animals.tasks.AnimalBehaviorSimulator;
import com.animals.utilities.RandomAnimalListGenerator;


public class Main {

    public static void main(String[] args) {

        // ArrayList <Animal> x = new ArrayList<>();
        // x.add(AnimalCreator.getAnimal(AnimalSpecies.CAT));
        // AnimalBehaviorSimulator animalBehaviorSimulator = new AnimalBehaviorSimulator(x, 3);
        AnimalBehaviorSimulator animalBehaviorSimulator = new AnimalBehaviorSimulator(new RandomAnimalListGenerator().generateListOfAnimals(3), 3);
        animalBehaviorSimulator.simulateDaysOfAnimals();

        // System.out.println(AnimalVoiceFactory.getVoice(AnimalSpecies.SKINNY_CAT));

    }
}
