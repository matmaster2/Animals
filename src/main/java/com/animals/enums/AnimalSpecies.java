package com.animals.enums;

import java.util.List;

import static com.animals.tasks.NameGenerator.nameGenerator;
import static com.animals.utilities.RandomNumberGenerator.generateRandomNumber;
import static java.util.Arrays.asList;

public enum AnimalSpecies {

    SKINNY_CAT(nameGenerator.getCatName(), generateWeight(20, 20), 15, 20),
    CAT(nameGenerator.getCatName(), generateWeight(80, 40), 20, 30),
    FAT_CAT(nameGenerator.getCatName(), generateWeight(130, 20), 22, 5),
    DOG(nameGenerator.getDogName(), generateWeight(30, 20), 30, 50),
    COW(nameGenerator.getCowName(), generateWeight(250, 40), 40, 10),
    OWL(nameGenerator.getOwlName(), generateWeight(15, 10), 30, 3),
    TALPA(nameGenerator.getTalpaName(), generateWeight(5, 8), 12, 2),
    DOLPHIN(nameGenerator.getDolphinName(), generateWeight(300, 50), 25, 80),
    PENGUIN(nameGenerator.getPenguinName(), generateWeight(20, 20), 20, 16),
    PANDA(nameGenerator.getPandaName(), generateWeight(200, 100), 20, 25),
    SLOTH(nameGenerator.getSlothName(), generateWeight(80, 40), 23, 2),
    RED_PANDA(nameGenerator.getPandaName(),100,10,40),
    NARWHAL("Narwalek", 2000, 200, 5),
    RED_COW(nameGenerator.getCowName(), 300, 45, 15),
    BLUE_COW(nameGenerator.getCowName(), 250, 35,20),
    GREEN_COW(nameGenerator.getCowName(), 350,43,10 ),
    YAK("JakiJak",30,30,30);

    private String name;
    private int weight;
    private int growth;
    private int moveSpeed;

    AnimalSpecies(String name, int weight, int growth, int moveSpeed) {
        this.name = name;
        this.weight = weight;
        this.growth = growth;
        this.moveSpeed = moveSpeed;
    }

    protected static int generateWeight(int basicWeight, int range) {
        return generateRandomNumber(basicWeight, range);
    }

    public static List<AnimalSpecies> getAnimalSpieces() {
        return asList(AnimalSpecies.values());
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getGrowth() {
        return growth;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }
}