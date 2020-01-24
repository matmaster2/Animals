package com.animals.tasks;

import com.animals.exceptions.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.animals.utilities.RandomNumberGenerator.generateRandomNumber;
import static java.lang.ClassLoader.getSystemClassLoader;

public class NameGenerator {

    public static final NameGenerator nameGenerator = new NameGenerator();
    private static final Logger log = LogManager.getLogger(NameGenerator.class);

    private String name = "";

    private void readFromFile(String filePath) {
        List<String> names = new ArrayList<>();

        InputStream inputStream = getSystemClassLoader().getResourceAsStream(String.valueOf(filePath));
        Optional.ofNullable(inputStream).orElseThrow(CustomException::new);

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream))) {
            name = fileReader.readLine();
            do {
                names.add(name);
                name = fileReader.readLine();
            } while (name != null);
            name = generateRandomName(names);
        } catch (IOException e) {
            log.error("Wystapil blad w klasie: {} - {} ", NameGenerator.class, e);
        }
    }


    public String getCatName() {
        readFromFile("names/cats_names");
        return name;
    }

    public String getCowName() {
        readFromFile("names/cows_names");
        return name;
    }

    public String getDogName() {
        readFromFile("names/dogs_names");
        return name;
    }

    public String getOwlName() {
        readFromFile("names/owls_names");
        return name;
    }

    public String getTalpaName(){
        readFromFile("names/talpas_names");
        return name;
    }

    public String getDolphinName(){
        readFromFile("names/dolphins_names");
        return name;
    }

    public String getPenguinName(){
        readFromFile("names/penguins_names");
        return name;
    }

    public String getPandaName(){
        readFromFile("names/pandas_names");
        return name;
    }

    public String getSlothName(){
        readFromFile("names/sloths_names");
        return name;
    }

    private String generateRandomName(List<String> names) {
        return (names.get(generateRandomNumber(names.size())));
    }
}

