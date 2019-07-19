package com.animals.factory;

import com.animals.basic.Animal;
import com.animals.basic.Cat;
import com.animals.basic.Dog;

public class AnimalFactory {

    private AnimalFactory(){}

    public static Animal getAnimal(String animal){
//todo jak usprawnic switcha? co mozna dac zamiast String animal?
        //todo java 12 nowy switch-case
        switch (animal){
            case "cat": return new Cat("Azzura");
            case "dog": return new Dog(); //todo przyjrzyj sie podpowiedzi
            default: return new Dog();
        }

    }
}
