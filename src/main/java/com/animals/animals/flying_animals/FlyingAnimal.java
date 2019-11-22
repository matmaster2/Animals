package com.animals.animals.flying_animals;

import com.animals.animals.Animal;
import com.animals.model.AnimalVoice;

abstract class FlyingAnimal extends Animal {
    FlyingAnimal(String name, int weight, int moveSpeed, AnimalVoice animalVoice) {
        super(name, weight, moveSpeed, animalVoice);
    }
}
