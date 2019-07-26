package com.animals.factory;

import com.animals.basic.Animal;
import com.animals.basic.Cat;
import com.animals.basic.Dog;

public class AnimalFactory {

    private AnimalFactory(){}

    public static Animal getAnimal(Animal animal){
        //"todo java 12 nowy switch-case" - nie moge za bardzo instalowac javy 12 na moim komputerze w pracy, przez co wolalbym tego nie uzywac
        switch (animal.toString()){
            case "cat": return new Cat("Azzura");
            case "dog": return new Dog("Ciapek");
            default: return null;
        }
    }
}
