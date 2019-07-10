package com.animals;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static java.lang.Math.random;

public class Main {

    private static final Logger LOG = LogManager.getLogger();
    private static final int DAY_IN_MINUTES = 60 * 24;
    private static final int NUMBER_OF_CATS = 2;
    private static final List<String> CAT_NAMES = Arrays.asList("Mika", "Hubert", "Bartus");

    public static void main(String[] args) {

        int i = 0;

        while (i < NUMBER_OF_CATS) {
            int minutesToEndOfDay = DAY_IN_MINUTES;
            Cat cat = new Cat(CAT_NAMES.get(i));
            while (minutesToEndOfDay > 0) {
                LOG.info("Dane na temat {}: ", cat.getName());
                int actionTime = generateRandomNumber();
                LOG.info("Czy {} jest wyspany? {}", cat.getName(), cat.isRested());
                actionTime = actionTime > minutesToEndOfDay ? minutesToEndOfDay : actionTime;
                if (cat.isRested()) {
                    cat.makeVoice(generateRandomNumber(10));
                    cat.walkInMinutes(actionTime);
                    LOG.info("{} chodził {} godzin i {} minut", cat.getName(), toHours(actionTime), actionTime % 60);
                } else {
                    cat.sleep(actionTime);
                    LOG.info("{} spał {} godzin i {} minut", cat.getName(), toHours(actionTime), actionTime % 60);
                }
                LOG.info("Do końca dnia pozostało: {} godzin i {} minut", toHours(minutesToEndOfDay - actionTime), (minutesToEndOfDay - actionTime) % 60);
                minutesToEndOfDay = minutesToEndOfDay - actionTime;
            }
            LOG.info("Czy kot jest wyspany? " + cat.isRested());
            i++;
        }
    }

    private static int toHours(int minutes) {
        return (minutes) / 60;
    }

    private static int generateRandomNumber() {
        return generateRandomNumber(100);
    }

    private static int generateRandomNumber(int scale) {
        return (int) (random() * scale);
    }

}
