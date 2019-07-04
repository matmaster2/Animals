package com.animals;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class Main {

    private static final int DAY_IN_MINUTES = 60 * 24;

    public static void main(String[] args) {
        int i = 0;
        List<Cat> CatsList = new ArrayList<>();

        do { //TODO czy 666 powinno byc tutaj? i dlaczego nie?  <-- spytac sie czemu nie powinoo byc wczesniej tam
            int minutesToEndOfDay = DAY_IN_MINUTES;
            CatsList.add(new Cat());
            while (minutesToEndOfDay > 0) {
                System.out.println("Dane na temat kota numer: "+i);
                int actionTime = generateRandomNumber();
                System.out.format("Czy kot jest wyspany? %b\n", CatsList.get(i).isRested());
                actionTime = actionTime > minutesToEndOfDay ? minutesToEndOfDay : actionTime;
                if (CatsList.get(i).isRested()) {
                    CatsList.get(i).makeVoice(generateRandomNumber(10));
                    CatsList.get(i).walkInMinutes(actionTime);
                    System.out.format("Kot chodził %d godzin i %d minut\n", toHours(actionTime), actionTime % 60);
                } else {
                    CatsList.get(i).sleep(actionTime);
                    System.out.format("Kot spał %d godzin i %d minut\n", toHours(actionTime), actionTime % 60);
                }
                System.out.format("Do końca dnia pozostało: %d godzin i %d minut\n", toHours(minutesToEndOfDay - actionTime), (minutesToEndOfDay - actionTime) % 60);
                minutesToEndOfDay = minutesToEndOfDay - actionTime;
            }
            System.out.println("Czy kot jest wyspany? " + CatsList.get(i).isRested());
            i++;
        } while (i < 666);
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
