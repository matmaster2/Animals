package com.animals.tasks;

import com.animals.animals.Animal;
import com.animals.enums.TypeOfAnimal;
import com.animals.factory.AnimalFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class SimulationOfTheDay {

    private static final Logger log = LogManager.getLogger(SimulationOfTheDay.class);

    private static final int DAY_IN_MINUTES = 60 * 24;

    private final int numberOfAnimals;
    private final int dayOfLife;
    private Random random = new Random();

    public SimulationOfTheDay(int numberOfAnimals, int dayOfLife) {
        this.numberOfAnimals = numberOfAnimals;
        this.dayOfLife = dayOfLife;
    }

    public void simulation() {
        List<Animal> animals = generateAnimals();
        for (int i = 1; i <= dayOfLife; i++) {
            log.info("\t\t\t\t\tDzień: {}", i);
            simulationOfTheDay(animals);
        }
    }

    private void simulationOfTheDay(List<Animal> animals) {
        animals.forEach(animal -> {
            int minutesToEndOfDay = DAY_IN_MINUTES;
            log.info("\t\t\t\t\tDane na temat {}: ", animal.getName());
            while (minutesToEndOfDay > 0) {
                int actionTime = generateRandomNumber();
                log.info("Czy {} jest wyspany? {}", animal.getName(), animal.isRested());
                actionTime = actionTime > minutesToEndOfDay ? minutesToEndOfDay : actionTime;
                if (animal.isRested()) {
                    animal.makeVoice(generateRandomNumber(10));
                    animal.walkInMinutes(actionTime);
                    log.info("{} chodził {} godzin i {} minut", animal.getName(), toHours(actionTime), actionTime % 60);
                } else {
                    animal.sleep(actionTime);
                    log.info("{} spał {} godzin i {} minut", animal.getName(), toHours(actionTime), actionTime % 60);
                }
                log.info("Do końca dnia pozostało: {} godzin i {} minut", toHours(minutesToEndOfDay - actionTime), (minutesToEndOfDay - actionTime) % 60);
                minutesToEndOfDay = minutesToEndOfDay - actionTime;
            }
            log.info("Czy zwierze jest wyspane? " + animal.isRested());
        });
    }


    private List<Animal> generateAnimals() {
        List<Animal> animalList = new ArrayList<>();
        for (int i = 0; i < numberOfAnimals; i++) {
            animalList.add(AnimalFactory.getAnimal(asList(TypeOfAnimal.values()).get(generateRandomNumber(TypeOfAnimal.values().length))));
        }
        return animalList;
    }

    private int toHours(int minutes) {
        return (minutes) / 60;
    }

    private int generateRandomNumber() {
        return generateRandomNumber(100);
    }

    private int generateRandomNumber(int scale) {
        return random.nextInt(scale);
    }
}
