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
                return generateAnimalVoice("voices/cats_voices");
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











