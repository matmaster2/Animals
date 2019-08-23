package com.animals.factory;

import com.animals.animals.*;
import com.animals.enums.TypeOfAnimal;
import com.animals.tasks.NameGenerator;

public class AnimalFactory {
    private static final NameGenerator nameGenerator = new NameGenerator();

    private AnimalFactory() {
    }

    public static Animal getAnimal(TypeOfAnimal typeOfAnimal) {

        switch (typeOfAnimal) {
            case SKINNY_CAT:
                return new Cat(nameGenerator.getCatName(), 30, 20);
            case CAT:
                return new Cat(nameGenerator.getCatName(), 100, 30);
            case FAT_CAT:
                return new Cat(nameGenerator.getCatName(), 150, 5);
            case DOG:
                return new Dog(nameGenerator.getDogName(), 50, 50);
            case COW:
                return new Cow(nameGenerator.getCowName(), 350, 10);
            case OWL:
                return new Owl(nameGenerator.getOwlName(), 25, 3);
            default:
                return null;
        }
    }
}

//todo waga zwierzat ma byc randomowa

/*
 public static Animal getAnimal(TypeOfAnimal typeOfAnimal){

return switch (typeOfAnimal){
 case SKINNY_CAT -> new Cat("Azzura",50,50);
 case CAT -> new Cat("Bartek");
 case FAT_CAT -> new Cat ("Hubert");
 case DOG -> new Dog("Ciapek");
 };
 }*/