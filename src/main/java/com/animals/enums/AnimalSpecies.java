package com.animals.enums;

import java.util.List;

import static java.util.Arrays.asList;

public enum AnimalSpecies {
    SKINNY_CAT,
    CAT,
    FAT_CAT,
    DOG,
    COW,
    OWL,
    TALPA,
    DOLPHIN,
    PENGUIN,
    PANDA,
    SLOTH;

    public static List<AnimalSpecies> getAnimalSpieces() {
        return asList(AnimalSpecies.values());
    }


}