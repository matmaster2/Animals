package com.animals.factory;

import com.animals.basic.Animal;
import com.animals.basic.Cat;
import com.animals.basic.Dog;
import com.animals.enums.TypeOfAnimal;

public class AnimalFactory {

    private AnimalFactory(){}

    public static Animal getAnimal(TypeOfAnimal animal){

        switch (animal){
            case SKINNY_CAT: return new Cat("Azzura");
            case CAT: return new Cat("Bartek");
            case FAT_CAT: return new Cat ("Hubert");
            case DOG: return new Dog("Ciapek");
            default: return null;
        }
    }
}




//"todo java 12 nowy switch-case"