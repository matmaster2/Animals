package com.animals.utilities;

import com.animals.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.animals.tasks.AnimalCreator.getRandomAnimal;

public class RandomAnimalListGenerator {

    public List<Animal> generateListOfAnimals(int numberOfAnimals) {
        List<Animal> animalList = new ArrayList<>();
        IntStream.range(0, numberOfAnimals).forEach(animal -> animalList.add(getRandomAnimal()));
        return animalList;
    }
}
