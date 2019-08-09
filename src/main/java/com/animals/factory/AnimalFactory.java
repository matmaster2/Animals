package com.animals.factory;

import com.animals.animals.Animal;
import com.animals.animals.Cat;
import com.animals.animals.Cow;
import com.animals.animals.Dog;
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
            case COW:
                return new Cow("Mucka", 350, 10);
            default:
                return null;
        }
    }
}

/*
todo:
   - nowa klasa do czytania losowego imienia dla danego zwierzecia,
   - co do nowej klasy -> w tej klasie bede musial przeczytac imiona z odpowiedneigo pliku (streamy!),
   - uzyj try with resources.
*/


/*
 public static Animal getAnimal(TypeOfAnimal typeOfAnimal){

return switch (typeOfAnimal){
 case SKINNY_CAT -> new Cat("Azzura",50,50);
 case CAT -> new Cat("Bartek");
 case FAT_CAT -> new Cat ("Hubert");
 case DOG -> new Dog("Ciapek");
 };
 }*/