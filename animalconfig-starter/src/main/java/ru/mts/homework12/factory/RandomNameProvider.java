package ru.mts.homework12.factory;

import java.util.Random;

public class RandomNameProvider {

    public static String chooseRandomName(String[] names) {
        var random = new Random();
        int randomIndex = random.nextInt(names.length);

        return names[randomIndex];
    }

}
