package com.animals.animals.types;

import com.animals.animals.Animal;
import com.animals.enums.AnimalSpecies;
import com.animals.model.AnimalVoice;

public class FlyingAnimal extends Animal {
    public FlyingAnimal(String name, int weight, int moveSpeed, AnimalVoice animalVoice, AnimalSpecies animalSpecies) {
        super(name, weight, moveSpeed, animalVoice, animalSpecies);
    }

}
