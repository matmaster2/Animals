package com.animals.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static com.animals.utilities.RandomNumberGenerator.generateRandomNumber;

public class NameGenerator {

    private static final Logger log = LogManager.getLogger(NameGenerator.class);

    private String name = "";

    private void readFromFile(String filePath) {
        List<String> names = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            name = fileReader.readLine();
            do {
                names.add(name);
                name = fileReader.readLine();
            } while (name != null);
            name = generateRandomName(names);
        } catch (Exception e) {
            log.error("Wystapil blad w klasie: {} - {} ", NameGenerator.class, e);
        }
    }


    public String getCatName() {
        readFromFile(".\\src\\main\\resources\\names\\cats_names"); //todo ogarnac te sciezki (skrocic je)
        return name;
    }

    public String getCowName() {
        readFromFile(".\\src\\main\\resources\\names\\cows_names");
        return name;
    }

    public String getDogName() {
        readFromFile(".\\src\\main\\resources\\names\\dogs_names");
        return name;
    }

    public String getOwlName() {
        readFromFile(".\\src\\main\\resources\\names\\owls_names");
        return name;
    }

    private String generateRandomName(List<String> names) {
        return (names.get(generateRandomNumber(names.size())));
    }
}

