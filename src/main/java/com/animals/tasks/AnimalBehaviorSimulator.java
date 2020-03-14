package com.animals.tasks;

import com.animals.animals.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.animals.tasks.AnimalCreator.getRandomAnimal;
import static com.animals.utilities.RandomNumberGenerator.generateRandomNumber;

public class AnimalBehaviorSimulator {

    private static final Logger log = LogManager.getLogger(AnimalBehaviorSimulator.class);

    private static final int DAY_IN_MINUTES = 60 * 24;
    private static final String TAB = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";

    private final int dayOfLife;
    private final List<Animal> animals;

    private AnimalBehaviorSimulator(List<Animal> animals, int dayOfLife) {
        this.animals = animals;
        this.dayOfLife = dayOfLife;
    }

    private static List<Animal> generateListOfAnimals(int numberOfAnimals) {
        List<Animal> animalList = new ArrayList<>();
        IntStream.range(0, numberOfAnimals).forEach(animal -> animalList.add(getRandomAnimal()));
        return animalList;
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

    public static class Builder {
        private List<Animal> animals;
        private int dayOfLife;

        public Builder() {
            animals = new ArrayList<Animal>();
        }

        public Builder addAnimal(Animal animal) {
            animals.add(animal);
            return this;
        }

        public Builder addAnimals(List<Animal> animals) {
            this.animals.addAll(animals);
            return this;
        }

        public Builder addRandomAnimals(int numberOfAnimals) {
            this.animals.addAll(generateListOfAnimals(numberOfAnimals));
            return this;
        }

        public Builder setNumberOfDays(int dayOfLife) {
            this.dayOfLife = dayOfLife;
            return this;
        }

        public AnimalBehaviorSimulator build() {
            return new AnimalBehaviorSimulator(animals, dayOfLife);
        }
    }
}
