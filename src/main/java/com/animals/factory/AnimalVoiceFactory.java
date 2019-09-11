package com.animals.factory;

import com.animals.enums.TypeOfAnimal;
import com.animals.exceptions.GenerateException;
import com.animals.model.AnimalVoice;
import com.google.gson.Gson;

import java.io.*;

import static java.lang.ClassLoader.getSystemClassLoader;

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

    private static AnimalVoice generateAnimalVoice(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getSystemClassLoader().getResourceAsStream(fileName)))) { //todo catch null, hint: Optional.ofNullable
            return gson.fromJson(reader, AnimalVoice.class);
        } catch (IOException e) {
            throw new GenerateException();
        } //todo  przerobic to: if(sNull(filepath) + InputStream input =Optional.ofNullable .... + .orElseThrow ->
    }
}
