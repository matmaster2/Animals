package com.animals.tasks;

import com.animals.basic.Animal;
import com.animals.enums.TypeOfAnimal;
import com.animals.factory.AnimalFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class SimulationOfTheDay {

    private final Logger log = LogManager.getLogger(SimulationOfTheDay.class);
    private final int DAY_IN_MINUTES = 60 * 24;
    private final int numberOfAnimals;
    private final int dayOfLife;

    public SimulationOfTheDay(int numberOfAnimals, int dayOfLife) {
        this.numberOfAnimals = numberOfAnimals;
        this.dayOfLife = dayOfLife;
    }

    public void simulation() {
        List<Animal> animals = generateAnimals();
        for (int j = 0; j < dayOfLife; j++) {
            int i = 0;
            log.info("                                                    Dzień: {}", j + 1);
            while (i < numberOfAnimals) {
                int minutesToEndOfDay = DAY_IN_MINUTES;
                Animal animal = animals.get(i);
                log.info("                                                Dane na temat {}: ", animal.getName());
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
                log.info("Czy kot jest wyspany? " + animal.isRested());
                i++;
            }
        }
    }

    private List generateAnimals() {
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
        Random r = new Random();
        return r.nextInt(scale);
    }
}
