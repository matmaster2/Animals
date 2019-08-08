package com.animals.tasks;

import com.animals.basic.Animal;
import com.animals.enums.TypeOfAnimal;
import com.animals.factory.AnimalFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static java.util.Arrays.asList;

public class SimulationOfTheDay {

    private static final Logger log = LogManager.getLogger(SimulationOfTheDay.class);
    private static final int DAY_IN_MINUTES = 60 * 24;
    protected final int numberOfAnimals;
    protected final int dayOfLife;

    public SimulationOfTheDay(int numberOfAnimals, int dayOfLife) {
        this.numberOfAnimals = numberOfAnimals;
        this.dayOfLife = dayOfLife;
    }

    int i = 0;

    public void simulation() {
        while (i < numberOfAnimals) {
            int minutesToEndOfDay = DAY_IN_MINUTES;
            Animal cat = AnimalFactory.getAnimal(asList(TypeOfAnimal.values()).get(generateRandomNumber(TypeOfAnimal.values().length)));
            while (minutesToEndOfDay > 0) {
                log.info("Dane na temat {}: ", cat.getName());
                int actionTime = generateRandomNumber();
                log.info("Czy {} jest wyspany? {}", cat.getName(), cat.isRested());
                actionTime = actionTime > minutesToEndOfDay ? minutesToEndOfDay : actionTime;
                if (cat.isRested()) {
                    cat.makeVoice(generateRandomNumber(10));
                    cat.walkInMinutes(actionTime);
                    log.info("{} chodził {} godzin i {} minut", cat.getName(), toHours(actionTime), actionTime % 60);
                } else {
                    cat.sleep(actionTime);
                    log.info("{} spał {} godzin i {} minut", cat.getName(), toHours(actionTime), actionTime % 60);
                }
                log.info("Do końca dnia pozostało: {} godzin i {} minut", toHours(minutesToEndOfDay - actionTime), (minutesToEndOfDay - actionTime) % 60);
                minutesToEndOfDay = minutesToEndOfDay - actionTime;
            }
            log.info("Czy kot jest wyspany? " + cat.isRested());
            i++;
        }
    }

    private static int toHours(int minutes) {
        return (minutes) / 60;
    }

    private static int generateRandomNumber() {
        return generateRandomNumber(100);
    }

    private static int generateRandomNumber(int scale) {
        Random r = new Random();
        return r.nextInt(scale);
    }
}
