package ru.mts.homework8.factory;

import java.util.Random;

public class RandomNameProvider {
    public static String chooseRandomName(String[] names){
        Random random = new Random();
        int randomIndex = random.nextInt(names.length);
        return names[randomIndex];
    }
}
