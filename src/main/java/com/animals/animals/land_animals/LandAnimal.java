package com.animals.animals.land_animals;

import com.animals.animals.Animal;
import com.animals.model.AnimalVoice;

abstract class LandAnimal extends Animal {
    LandAnimal(String name, int weight, int moveSpeed, AnimalVoice animalVoice) {
        super(name, weight, moveSpeed, animalVoice);
    }
}
