package com.animals.tasks;

import com.animals.animals.Animal;
import com.animals.enums.AnimalSpecies;
import com.animals.factory.AnimalVoiceFactory;
import com.animals.model.AnimalVoice;

import static com.animals.enums.AnimalSpecies.getAnimalSpieces;
import static com.animals.utilities.RandomNumberGenerator.generateRandomNumber;

public class AnimalCreator {

    private AnimalCreator() {
    }

    private static AnimalSpecies getRandomAnimalType() {
        return getAnimalSpieces().get(generateRandomNumber(getAnimalSpieces().size()));
    }

    public static Animal getRandomAnimal() {
        return getAnimal(getRandomAnimalType());
    }

    public static Animal getAnimal(AnimalSpecies animalSpecies) {
        AnimalVoice animalVoice = AnimalVoiceFactory.getVoice(animalSpecies);
        return getAnimalData(animalSpecies, animalVoice);

    }

    private static Animal getAnimalData(AnimalSpecies animalSpecies, AnimalVoice animalVoice) {
        return new Animal.Builder()
                .setName(animalSpecies.getName())
                .setWeight(animalSpecies.getWeight())
                .setGrowth(animalSpecies.getGrowth())
                .setMoveSpeed(animalSpecies.getMoveSpeed())
                .setAnimalVoice(animalVoice)
                .setAnimalSpecies(animalSpecies)
                .build();
    }

}