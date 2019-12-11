package com.animals.factory;

import com.animals.animals.Animal;
import com.animals.animals.types.FlyingAnimal;
import com.animals.animals.types.LandAnimal;
import com.animals.animals.types.WaterAnimal;
import com.animals.enums.AnimalSpecies;
import com.animals.model.AnimalVoice;
import com.animals.tasks.NameGenerator;

import static com.animals.enums.AnimalSpecies.getAnimalSpieces;
import static com.animals.utilities.RandomNumberGenerator.generateRandomNumber;

public class AnimalFactory {
    private static final NameGenerator nameGenerator = new NameGenerator();

    private AnimalFactory() {
    }

    private static AnimalSpecies getRandomAnimalType() {
        return getAnimalSpieces().get(generateRandomNumber(getAnimalSpieces().size()));
    }

    public static Animal getRandomAnimal() {
        return getAnimal(getRandomAnimalType());
    }

    public static Animal getAnimal(AnimalSpecies animalSpecies) {
        AnimalVoice animalVoice = AnimalVoiceFactory.getVoice(animalSpecies);
        //TODO dodaj do każdego zwierzęcia wzrost
        switch (animalSpecies) {
            case SKINNY_CAT:
                return new LandAnimal(nameGenerator.getCatName(), generateRandomNumber(20, 20), 20, animalVoice, animalSpecies);
            case CAT:
                return new LandAnimal(nameGenerator.getCatName(), generateRandomNumber(80, 40), 30, animalVoice, animalSpecies);
            case FAT_CAT:
                return new LandAnimal(nameGenerator.getCatName(), generateRandomNumber(130, 20), 5, animalVoice, animalSpecies);
            case DOG:
                return new LandAnimal(nameGenerator.getDogName(), generateRandomNumber(30, 20), 50, animalVoice, animalSpecies);
            case COW:
                return new LandAnimal(nameGenerator.getCowName(), generateRandomNumber(250, 40), 10, animalVoice, animalSpecies);
            case OWL:
                return new FlyingAnimal(nameGenerator.getOwlName(), generateRandomNumber(15, 10), 3, animalVoice, animalSpecies);
            case TALPA:
                return new LandAnimal(nameGenerator.getTalpaName(), generateRandomNumber(5, 8), 2, animalVoice, animalSpecies);
            case DOLPHIN:
                return new WaterAnimal(nameGenerator.getDolphinName(), generateRandomNumber(300, 50), 80, animalVoice, animalSpecies);
            case PENGUIN:
                return new LandAnimal(nameGenerator.getPenguinName(), generateRandomNumber(20, 20), 30, animalVoice, animalSpecies);
            case PANDA:
                return new LandAnimal(nameGenerator.getPandaName(), generateRandomNumber(200, 100), 10, animalVoice, animalSpecies);
            case SLOTH:
                return new LandAnimal(nameGenerator.getSlothName(), generateRandomNumber(80, 40), 2, animalVoice,animalSpecies);
            //TODO dodaj pande czerwoną
            //TODO dodaj narwala
            //TODO dodaj 3 gatunki krowy
            //TODO dodaj jaka
            default:
                return null;
        }
    }
}