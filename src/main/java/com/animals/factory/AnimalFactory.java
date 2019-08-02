package com.animals.factory;

import com.animals.basic.Animal;
import com.animals.basic.Cat;
import com.animals.basic.Dog;
import com.animals.enums.TypeOfAnimal;

public class AnimalFactory {

    private AnimalFactory() {
    }

    public static Animal getAnimal(TypeOfAnimal typeOfAnimal) {

        switch (typeOfAnimal) {
            case SKINNY_CAT:
                return new Cat("Azzura", 30, 20);
            case CAT:
                return new Cat("Bartek", 100, 30);
            case FAT_CAT:
                return new Cat("Hubert", 150, 5);
            case DOG:
                return new Dog("Ciapek", 50, 50);
            default:
                return null;
        }
    }
}



/*
 public static Animal getAnimal(TypeOfAnimal typeOfAnimal){

 Animal animal = switch (typeOfAnimal){
 case SKINNY_CAT -> new Cat("Azzura");
 case CAT -> new Cat("Bartek");
 case FAT_CAT -> new Cat ("Hubert");
 case DOG -> new Dog("Ciapek");
 default -> {
 break null;
 }
 };
 return animal;
 }*/