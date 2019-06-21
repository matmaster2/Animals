package com.animals;

import static java.lang.Math.min;
import static java.lang.Math.random;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat();
        int minutesToEndOfDay = 840;

        while (minutesToEndOfDay > 0) {
            int save = generateRandomNumber();
            System.out.println("Czy kot jest wyspany? " + cat.isRested());
            save = save > minutesToEndOfDay ? minutesToEndOfDay : save;
            if (cat.isRested()) {
//                cat.makeVoice((int) random() * 10);
                cat.walkInMinutes(save);
                System.out.println("Kot chodził: " + save);
            } else {
                cat.sleep(save);
                System.out.println("Kot spal: " + save);
            }
            minutesToEndOfDay = minutesToEndOfDay - save;
        }
        System.out.println("Czy kot jest wyspany? " + cat.isRested());
    }

    static int generateRandomNumber() {
        return (int) (random() * 100);
    }
}
