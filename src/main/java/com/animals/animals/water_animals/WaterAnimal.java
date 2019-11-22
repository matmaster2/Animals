package com.animals.animals.water_animals;

import com.animals.animals.Animal;
import com.animals.model.AnimalVoice;

abstract class WaterAnimal extends Animal {
    WaterAnimal(String name, int weight, int moveSpeed, AnimalVoice animalVoice) {
        super(name, weight, moveSpeed, animalVoice);
    }
}
