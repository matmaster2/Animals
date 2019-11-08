package com.animals.factory;

import com.animals.enums.TypeOfAnimal;
import com.animals.exceptions.CustomException;
import com.animals.model.AnimalVoice;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

import static java.lang.ClassLoader.getSystemClassLoader;
import static java.util.Objects.isNull;

public class AnimalVoiceFactory {
    private static final Gson gson = new Gson();

    private AnimalVoiceFactory() {
    }

    public static AnimalVoice getVoice(TypeOfAnimal typeOfAnimal) {

        switch (typeOfAnimal) {
            case SKINNY_CAT:
            case CAT:
            case FAT_CAT:
                return generateAnimalVoice("voices/cats_voices");
            case DOG:
                return generateAnimalVoice("voices/dogs_voices");
            case COW:
                return generateAnimalVoice("voices/cows_voices");
            case OWL:
                return generateAnimalVoice("voices/owls_voices");
            case TALPA:
                return generateAnimalVoice("voices/talpas_voices");
            case DOLPHIN:
                return generateAnimalVoice("voices/dolphins_voices");
            case PENGUIN:
                return generateAnimalVoice("voices/penguins_voices");
            case PANDA:
                return generateAnimalVoice("voices/pandas_voices");
            case SLOTH:
                return generateAnimalVoice("voices/sloths_voices");
        }
        return null;
    }

    private static AnimalVoice generateAnimalVoice(String filePath) {
        if (isNull(filePath))
            throw new CustomException();
        InputStream inputStream = getSystemClassLoader().getResourceAsStream(filePath);
        Optional.ofNullable(inputStream).orElseThrow(CustomException::new);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return gson.fromJson(reader, AnimalVoice.class);
        } catch (IOException e) {
            throw new CustomException();
        }
    }
}











