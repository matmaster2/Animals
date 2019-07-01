package com.animals;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class Main {
    
    static int minutesToEndOfDay = 60 * 24; //static final int TODO dopytac - czy na pewno final?
    
    public static void main(String[] args) {

       // List<Cat> CatsList = new ArrayList<Cat>();
        Cat cat = new Cat(); //TODO przydałby się drugi kot, a może trzy. Chociaż nie, lepiej 666 kotów <----- spytac o szczegoly
       // CatsList.add(cat);


        while (minutesToEndOfDay > 0) {
            int actionTime = generateRandomNumber();
            System.out.format("Czy kot jest wyspany? %b\n", cat.isRested());
            //System.out.println("Czy kot jest wyspany? " + cat.isRested()); //Sprawdź sobie String.format("%s", "text")
            actionTime = actionTime > minutesToEndOfDay ? minutesToEndOfDay : actionTime;
            if (cat.isRested()) {
                cat.makeVoice(actionTime);
                cat.walkInMinutes(actionTime);
                System.out.println("Kot chodził: " + actionTime/60+" godzin i "+ actionTime%60 +" minut\nDo końca dnia pozostało: "+(minutesToEndOfDay-actionTime)/60 +" godzin i "+(minutesToEndOfDay-actionTime)%60+" minut");
            } else {
                cat.sleep(actionTime);
                System.out.println("Kot spał: " + actionTime/60+" godzin i "+ actionTime%60 +" minut\nDo końca dnia pozostało: "+(minutesToEndOfDay-actionTime)/60 +" godzin i "+(minutesToEndOfDay-actionTime)%60+" minut");
            }
            minutesToEndOfDay = minutesToEndOfDay - actionTime;
        }
        System.out.println("Czy kot jest wyspany? " + cat.isRested());
    }

    private static int generateRandomNumber() { 
        return (int) (random() * 100);
    }

}
