package com.animals;

import com.animals.enums.TypeOfAnimal;
import com.animals.factory.AnimalVoiceFactory;


public class Main {

    public static void main(String[] args) {
        //SimulationOfTheDay simulationOfTheDay = new SimulationOfTheDay(3, 3);
        // simulationOfTheDay.simulation();
        System.out.println(AnimalVoiceFactory.getAnimal(TypeOfAnimal.SKINNY_CAT));
    }

}
