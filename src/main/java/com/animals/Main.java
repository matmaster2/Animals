package com.animals;

import static java.lang.Math.random;

public class Main {

    private static final int DAY_IN_MINUTES = 60 * 24;

    public static void main(String[] args) {
        int minutesToEndOfDay = DAY_IN_MINUTES;

        // List<Cat> CatsList = new ArrayList<Cat>();
        Cat cat = new Cat(); //TODO przydałby się drugi kot, a może trzy. Chociaż nie, lepiej 666 kotów <----- spytac o szczegoly
        // CatsList.add(cat);

        while (minutesToEndOfDay > 0) {
            int actionTime = generateRandomNumber();
            System.out.format("Czy kot jest wyspany? %b\n", cat.isRested());
            //System.out.println("Czy kot jest wyspany? " + cat.isRested()); //Sprawdź sobie String.format("%s", "text")
            actionTime = actionTime > minutesToEndOfDay ? minutesToEndOfDay : actionTime;
            if (cat.isRested()) {
                cat.makeVoice(generateRandomNumber(10));
                cat.walkInMinutes(actionTime);
                System.out.format("Kot chodził %d godzin i %d minut\n", toHours(actionTime), actionTime % 60);
            } else {
                cat.sleep(actionTime);
                System.out.format("Kot spał %d godzin i %d minut\n", toHours(actionTime), actionTime % 60);
            }
            System.out.format("Do końca dnia pozostało: %d godzin i %d minut\n", toHours(minutesToEndOfDay - actionTime), (minutesToEndOfDay - actionTime) % 60);
            minutesToEndOfDay = minutesToEndOfDay - actionTime;
        }
        System.out.println("Czy kot jest wyspany? " + cat.isRested());
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
