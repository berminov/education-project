package ru.mts.homework10.factory;

import java.util.Random;

public class RandomNameProvider {
    public static String chooseRandomName(String[] names){
        Random random = new Random();
        int randomIndex = random.nextInt(names.length);
        return names[randomIndex];
    }
}
