package com.animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.random;

public class Main {

    private static final int DAY_IN_MINUTES = 60 * 24;
    private static final int NUMBER_OF_CATS = 2;
    private static final List<String> CAT_NAMES = Arrays.asList("Mika", "Hubert", "Bartus");

    public static void main(String[] args) {
        int i = 0;

        while (i < NUMBER_OF_CATS) {
            int minutesToEndOfDay = DAY_IN_MINUTES;
            Cat cat = new Cat(CAT_NAMES.get(i));
            while (minutesToEndOfDay > 0) {
                System.out.format("Dane na temat %s: ", cat.getName()); //TODO use logger instead
                int actionTime = generateRandomNumber();
                System.out.format("Czy %s jest wyspany? %b\n", cat.getName(), cat.isRested()); //TODO use logger instead
                actionTime = actionTime > minutesToEndOfDay ? minutesToEndOfDay : actionTime;
                if (cat.isRested()) {
                    cat.makeVoice(generateRandomNumber(10));
                    cat.walkInMinutes(actionTime);
                    System.out.format("%s chodził %d godzin i %d minut\n",cat.getName(), toHours(actionTime), actionTime % 60); //TODO use logger instead
                } else {
                    cat.sleep(actionTime);
                    System.out.format("%s spał %d godzin i %d minut\n",cat.getName(), toHours(actionTime), actionTime % 60); //TODO use logger instead
                }
                System.out.format("Do końca dnia pozostało: %d godzin i %d minut\n", toHours(minutesToEndOfDay - actionTime), (minutesToEndOfDay - actionTime) % 60); //TODO use logger instead
                minutesToEndOfDay = minutesToEndOfDay - actionTime;
            }
            System.out.println("Czy kot jest wyspany? " + cat.isRested()); //TODO use logger instead
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
