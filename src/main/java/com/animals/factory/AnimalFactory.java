package com.animals.factory;

import com.animals.animals.*;
import com.animals.animals.flying_animals.Owl;
import com.animals.animals.land_animals.*;
import com.animals.animals.water_animals.Dolphin;
import com.animals.enums.TypeOfAnimal;
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
        switch (typeOfAnimal) {
            case SKINNY_CAT:
                return new Cat(nameGenerator.getCatName(), generateRandomNumber(20, 20), 20);
            case CAT:
                return new Cat(nameGenerator.getCatName(), generateRandomNumber(80, 40), 30);
            case FAT_CAT:
                return new Cat(nameGenerator.getCatName(), generateRandomNumber(130, 20), 5);
            case DOG:
                return new Dog(nameGenerator.getDogName(), generateRandomNumber(30, 20), 50);
            case COW:
                return new Cow(nameGenerator.getCowName(), generateRandomNumber(250, 40), 10);
            case OWL:
                return new Owl(nameGenerator.getOwlName(), generateRandomNumber(15, 10), 3);
            case TALPA:
                return new Talpa(nameGenerator.getTalpaName(), generateRandomNumber(5, 8), 2);
            case DOLPHIN:
                return new Dolphin(nameGenerator.getDolphinName(), generateRandomNumber(300,50),80);
            case PENGUIN:
                return new Penguin(nameGenerator.getPenguinName(), generateRandomNumber(20,20), 30);
            case PANDA:
                return new Panda(nameGenerator.getPandaName(), generateRandomNumber(200, 100), 10);
            case SLOTH:
                return new Sloth(nameGenerator.getSlothName(), generateRandomNumber(80, 40),2);
                //TODO dodaj pande czerwoną
                //TODO dodaj narwala
                //TODO dodaj 3 gatunki krowy
                //TODO dodaj jaka
            default:
                return null;
        }
    }
}