package com.animals.tasks;

import com.animals.animals.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.animals.utilities.RandomNumberGenerator.generateRandomNumber;

public class AnimalBehaviorSimulator {

    private static final Logger log = LogManager.getLogger(AnimalBehaviorSimulator.class);

    private static final int DAY_IN_MINUTES = 60 * 24;
    private static final String TAB = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";

    private final int dayOfLife;
    private final List <Animal> animals;

    public AnimalBehaviorSimulator(List <Animal> animals, int dayOfLife) {
        this.animals = animals;
        this.dayOfLife = dayOfLife;
    }

    public void simulateDaysOfAnimals() {
        for (int i = 1; i <= dayOfLife; i++) {
            log.info(TAB + "Dzień: {}", i);
            simulateDayOfAnimals(animals);
        }
    }

    private void simulateDayOfAnimals(List<Animal> animals) {
        animals.forEach(this::simulateOfTheDay);
    }

    private void simulateOfTheDay(Animal animal) {
        int minutesToEndOfDay = DAY_IN_MINUTES;
        log.info(TAB + "Dane na temat {}: ", animal.getName());
        while (minutesToEndOfDay > 0) {
            int actionTime = generateRandomNumber();
            log.info("Czy {} jest wyspany? {}", animal.getName(), animal.isRested());
            actionTime = actionTime > minutesToEndOfDay ? minutesToEndOfDay : actionTime;
            if (animal.isRested()) {
                try {
                    animal.makeVoice(generateRandomNumber(10));
                } catch (NullPointerException e) {
                    throw new NullPointerException("Nie znaleziono ścieżki do pliku z głosami");
                }
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

    private int toHours(int minutes) {
        return (minutes) / 60;
    }

}
