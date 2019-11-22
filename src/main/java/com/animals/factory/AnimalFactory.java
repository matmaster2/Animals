package com.animals.factory;

import com.animals.animals.Animal;
import com.animals.animals.flying_animals.Owl;
import com.animals.animals.land_animals.*;
import com.animals.animals.water_animals.Dolphin;
import com.animals.enums.TypeOfAnimal;
import com.animals.model.AnimalVoice;
import com.animals.tasks.NameGenerator;

import static com.animals.utilities.RandomNumberGenerator.generateRandomNumber;
import static java.util.Arrays.asList;

public class AnimalFactory {
    private static final NameGenerator nameGenerator = new NameGenerator();

    private AnimalFactory() {
    }

    private static TypeOfAnimal getRandomAnimalType() {
        return asList(TypeOfAnimal.values()).get(generateRandomNumber(TypeOfAnimal.values().length));
    }

    public static Animal getRandomAnimal() {
        return getAnimal(getRandomAnimalType());
    }

    public static Animal getAnimal(TypeOfAnimal typeOfAnimal) {
        AnimalVoice animalVoice = AnimalVoiceFactory.getVoice(typeOfAnimal);
        switch (typeOfAnimal) {
            case SKINNY_CAT:
                return new Cat(nameGenerator.getCatName(), generateRandomNumber(20, 20), 20, animalVoice);
            case CAT:
                return new Cat(nameGenerator.getCatName(), generateRandomNumber(80, 40), 30, animalVoice);
            case FAT_CAT:
                return new Cat(nameGenerator.getCatName(), generateRandomNumber(130, 20), 5, animalVoice);
            case DOG:
                return new Dog(nameGenerator.getDogName(), generateRandomNumber(30, 20), 50, animalVoice);
            case COW:
                return new Cow(nameGenerator.getCowName(), generateRandomNumber(250, 40), 10, animalVoice);
            case OWL:
                return new Owl(nameGenerator.getOwlName(), generateRandomNumber(15, 10), 3, animalVoice);
            case TALPA:
                return new Talpa(nameGenerator.getTalpaName(), generateRandomNumber(5, 8), 2, animalVoice);
            case DOLPHIN:
                return new Dolphin(nameGenerator.getDolphinName(), generateRandomNumber(300, 50), 80, animalVoice);
            case PENGUIN:
                return new Penguin(nameGenerator.getPenguinName(), generateRandomNumber(20, 20), 30, animalVoice);
            case PANDA:
                return new Panda(nameGenerator.getPandaName(), generateRandomNumber(200, 100), 10, animalVoice);
            case SLOTH:
                return new Sloth(nameGenerator.getSlothName(), generateRandomNumber(80, 40), 2, animalVoice);
            //TODO dodaj pande czerwoną
            //TODO dodaj narwala
            //TODO dodaj 3 gatunki krowy
            //TODO dodaj jaka
            default:
                return null;
        }
    }
}