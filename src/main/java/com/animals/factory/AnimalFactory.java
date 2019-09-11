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
                return new Cat(nameGenerator.getCatName(), 20+generateRandomNumber(20), 20);//todo ogarnij generator (drugi paremetr)
            case CAT:
                return new Cat(nameGenerator.getCatName(), 80+generateRandomNumber(40), 30);
            case FAT_CAT:
                return new Cat(nameGenerator.getCatName(), 130+generateRandomNumber(20), 5);
            case DOG:
                return new Dog(nameGenerator.getDogName(), 30+generateRandomNumber(20), 50);
            case COW:
                return new Cow(nameGenerator.getCowName(), 250+generateRandomNumber(40), 10);
            case OWL:
                return new Owl(nameGenerator.getOwlName(), 15+generateRandomNumber(10), 3);
            case TALPA:
                return new Talpa(nameGenerator.getTalpaName(), 5+generateRandomNumber(8), 2);
                //todo pingwin i delfin
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

