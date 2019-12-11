package com.animals;

import com.animals.enums.AnimalSpecies;
import com.animals.tasks.AnimalBehaviorSimulator;


public class Main {

    public static void main(String[] args) {
     AnimalBehaviorSimulator animalBehaviorSimulator = new AnimalBehaviorSimulator(3, 3);
     animalBehaviorSimulator.simulation();

     // System.out.println(AnimalVoiceFactory.getVoice(AnimalSpecies.SKINNY_CAT));


    }

}
