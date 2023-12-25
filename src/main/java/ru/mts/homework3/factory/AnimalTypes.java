package ru.mts.homework3.factory;

import java.util.List;

public enum AnimalTypes {
    BEAR, WOLF, CAT, PARROT;
    public static String getRandomType(){
        List<String> animalTypes = List.of(AnimalTypes.values().toString());
        int rDigit =  (int)(Math.random()*100 % animalTypes.size());
        return animalTypes.get(rDigit);

    }
}

