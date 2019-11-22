package com.animals.tasks;

import com.animals.animals.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.animals.factory.AnimalFactory.getRandomAnimal;
import static com.animals.utilities.RandomNumberGenerator.generateRandomNumber;

public class SimulationOfTheDay { // ta klasa jest SimulationOfTheDay czy ona służy do SimulationOfTheDay? chodzi o nazwę

    private static final Logger log = LogManager.getLogger(SimulationOfTheDay.class);

    private static final int DAY_IN_MINUTES = 60 * 24;
    private static final String TAB = "\t\t\t\t\t\t\t\t\t\t";

    private final int numberOfAnimals;
    private final int dayOfLife;

    public SimulationOfTheDay(int numberOfAnimals, int dayOfLife) {
        this.numberOfAnimals = numberOfAnimals;
        this.dayOfLife = dayOfLife;
    }

    public void simulation() {
        List<Animal> animals = generateAnimals();
        for (int i = 1; i <= dayOfLife; i++) {
            log.info(TAB + "Dzień: {}", i);
            simulationOfTheDay(animals);
            System.out.println(animals.get(0).getTypeOfAnimal()); //do testow
            animals.forEach(System.out::println); //do testow
        }
    }

    private void simulationOfTheDay(List<Animal> animals) {
        animals.forEach(animal -> {
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
            log.info("Czy zwierze jest wyspane? " + animal.isRested());
        });
    }


    private List<Animal> generateAnimals() {
        List<Animal> animalList = new ArrayList<>();
        for (int i = 0; i < numberOfAnimals; i++) { //todo IntStream
            animalList.add(getRandomAnimal());
        }
        return animalList;
    }

    private int toHours(int minutes) {
        return (minutes) / 60;
    }

}
