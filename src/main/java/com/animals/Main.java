package com.animals;

import static java.lang.Math.random;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat(); //TODO przydałby się drugi kot, a może trzy. Chociaż nie, lepiej 666 kotów
        int minutesToEndOfDay = 840; // 60 * 24 czasami ułatwia życie a niewiele kosztuje TODO static final int

        while (minutesToEndOfDay > 0) {
            int save = generateRandomNumber(); //Przydałaby się lepsza nazna dla save
            System.out.println("Czy kot jest wyspany? " + cat.isRested()); //Sprawdź sobie String.format("%s", "text")
            save = save > minutesToEndOfDay ? minutesToEndOfDay : save;
            if (cat.isRested()) {
//                cat.makeVoice((int) random() * 10); //TODO aktywuj to
                cat.walkInMinutes(save);
                System.out.println("Kot chodził: " + save);  //Sprawdź sobie String.format("%s", "text") TODO wypisz ile pozostało do końca dnia i podaj jednostki
            } else {
                cat.sleep(save);
                System.out.println("Kot spal: " + save); //Sprawdź sobie String.format("%s", "text") TODO wypisz ile pozostało do końca dnia i podaj jednostki
            }
            minutesToEndOfDay = minutesToEndOfDay - save;
        }
        System.out.println("Czy kot jest wyspany? " + cat.isRested());
    }

    static int generateRandomNumber() { //TODO zrób prywatne
        return (int) (random() * 100);
    }
}
