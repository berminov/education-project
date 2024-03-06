package ru.mts.homework10.domain.enums;

import ru.mts.homework10.factory.*;

import java.util.List;

public enum AnimalType {

    BEAR(BearFactory.class),
    WOLF(WolfFactory.class),
    CAT(CatFactory.class),
    PARROT(ParrotFactory.class);

    private final Class<? extends AnimalFactory> factoryClass;

    AnimalType(Class<? extends AnimalFactory> factoryClass) {
        this.factoryClass = factoryClass;
    }

    public static AnimalType getRandomType() {
        List<AnimalType> animalTypes = List.of(AnimalType.values());
        int rDigit = (int) (Math.random() * 100 % animalTypes.size());

        return animalTypes.get(rDigit);
    }

    public Class<? extends AnimalFactory> getFactoryClass() {
        return factoryClass;
    }

}

