package com.animals.tasks;

import com.animals.animals.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.animals.factory.AnimalFactory.getRandomAnimal;
import static com.animals.utilities.RandomNumberGenerator.generateRandomNumber;

public class AnimalBehaviorSimulator {

    private static final Logger log = LogManager.getLogger(AnimalBehaviorSimulator.class);

    private static final int DAY_IN_MINUTES = 60 * 24;
    private static final String TAB = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";

    private final int numberOfAnimals;
    private final int dayOfLife;

    public AnimalBehaviorSimulator(int numberOfAnimals, int dayOfLife) {
        this.numberOfAnimals = numberOfAnimals;
        this.dayOfLife = dayOfLife;
    }

    public void simulation() {
        List<Animal> animals = generateAnimals();
        for (int i = 1; i <= dayOfLife; i++) {
            log.info(TAB + "Dzień: {}", i);
            animalBehaviorSimulation(animals);
            System.out.println(animals.get(0).getTypeOfAnimalSpieces()); //do testow
            animals.forEach(System.out::println); //do testow
        }
    }

    private void animalBehaviorSimulation(List<Animal> animals) {
        animals.forEach(animal -> {
            simulationOfTheDay(animal);
        });
    }

    private void simulationOfTheDay(Animal animal) {
        int minutesToEndOfDay = DAY_IN_MINUTES;
        log.info(TAB + "Dane na temat {}: ", animal.getName());

        while (minutesToEndOfDay > 0) {
            int actionTime = generateRandomNumber();
            log.info("Czy {} jest wyspany? {}", animal.getName(), animal.isRested());
            actionTime = actionTime > minutesToEndOfDay ? minutesToEndOfDay : actionTime;
            if (animal.isRested()) {
                animal.makeVoice(generateRandomNumber(10));
                animal.moveInMinutes(actionTime);
                log.info("{} chodził {} godzin i {} minut", animal.getName(), toHours(actionTime), actionTime % 60);
            } else {
                animal.sleep(actionTime);
                log.info("{} spał {} godzin i {} minut", animal.getName(), toHours(actionTime), actionTime % 60);
            }
            log.info("Do końca dnia pozostało: {} godzin i {} minut", toHours(minutesToEndOfDay - actionTime), (minutesToEndOfDay - actionTime) % 60);
            minutesToEndOfDay = minutesToEndOfDay - actionTime;
        }
    }


    private List<Animal> generateAnimals() {
        List<Animal> animalList = new ArrayList<>();
        IntStream.range(0, numberOfAnimals).forEach(animal -> animalList.add(getRandomAnimal()));
        return animalList;
    }

    private int toHours(int minutes) {
        return (minutes) / 60;
    }

}
