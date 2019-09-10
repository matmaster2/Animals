package com.animals.utilities;

import java.util.Random;


public class RandomNumberGenerator {

    private static Random random = new Random();

    public static int generateRandomNumber() {
        return generateRandomNumber(100);
    }

    public static int generateRandomNumber(int scale) {
        return random.nextInt(scale);
    }
}


