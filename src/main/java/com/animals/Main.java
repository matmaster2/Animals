package com.animals;

import com.animals.tasks.SimulationOfTheDay;


public class Main {

    public static void main(String[] args) {
        SimulationOfTheDay simulationOfTheDay = new SimulationOfTheDay(5, 2);
        simulationOfTheDay.simulation();
    }

}
