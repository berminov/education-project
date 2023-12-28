package ru.mts.homework4.factory;

import java.util.List;

public enum AnimalTypes {
    BEAR, WOLF, CAT, PARROT;

    public static AnimalTypes getRandomType() {
        List<AnimalTypes> animalTypes = List.of(AnimalTypes.values());
        int rDigit = (int) (Math.random() * 100 % animalTypes.size());
        return animalTypes.get(rDigit);
    }
}

