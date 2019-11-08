package com.animals.factory;

import com.animals.animals.*;
import com.animals.enums.TypeOfAnimal;
import com.animals.tasks.NameGenerator;

import static com.animals.utilities.RandomNumberGenerator.generateRandomNumber;

public class AnimalFactory {
    private static final NameGenerator nameGenerator = new NameGenerator();

    private AnimalFactory() {
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
            default:
                return null;
        }
    }
}

/*
     public static Animal getAnimal(TypeOfAnimal typeOfAnimal){

    return switch (typeOfAnimal){
     case SKINNY_CAT -> new Cat("Azzura",50,50);
     case CAT -> new Cat("Bartek");
     case FAT_CAT -> new Cat ("Hubert");
     case DOG -> new Dog("Ciapek");
     };
     }*/

