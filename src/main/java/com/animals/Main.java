package com.animals;

import com.animals.enums.TypeOfAnimal;
import com.animals.factory.AnimalVoiceFactory;
import com.animals.tasks.SimulationOfTheDay;


public class Main {

    public static void main(String[] args) {
        SimulationOfTheDay simulationOfTheDay = new SimulationOfTheDay(3, 3);
        simulationOfTheDay.simulation();

      // System.out.println(AnimalVoiceFactory.getVoice(TypeOfAnimal.SKINNY_CAT));
    }

}
