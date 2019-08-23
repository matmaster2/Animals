package com.animals.factory;

import com.animals.enums.TypeOfAnimal;
import com.animals.model.AnimalVoice;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;

import java.io.*;

import static java.lang.ClassLoader.getSystemClassLoader;

public class AnimalVoiceFactory {
    private static final Gson gson = new Gson();

    private AnimalVoiceFactory() {
    }

    public static AnimalVoice getAnimal(TypeOfAnimal typeOfAnimal) {

        switch (typeOfAnimal) {
            case SKINNY_CAT:
                return generateAnimalVoice("./voices/cats_voices");
        }
        return null;
    }

    private static AnimalVoice generateAnimalVoice(@NotNull String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getSystemClassLoader().getResourceAsStream(fileName)))) { //todo catch null, hint: Optional.ofNullable
            return gson.fromJson(reader, AnimalVoice.class);
        } catch (IOException e) {
            throw new RuntimeException(e); //todo stworzyc wlasny wyjatek,
        }
    }
}
