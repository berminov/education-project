package ru.mts.homework6.factory;


import ru.mts.homework6.domain.abstraction.Animal;
import ru.mts.homework6.domain.enums.AnimalType;
import ru.mts.homework6.domain.enums.CharacterType;
import ru.mts.homework6.domain.enums.NameType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OneRandomAnimal {
    public static Animal createAnimal() {

        AnimalFactory animalFactory = createByType();
        Animal animal = animalFactory.createAnimal();

        animal.setBirthDate(RandomDateProvider.createRandomDate());
        animal.setName(NameType.getRandomName());
        animal.setCost(BigDecimal.valueOf(Math.random() * 10000).setScale(2, RoundingMode.HALF_UP));
        animal.setCharacter(CharacterType.randomCharacter());
        animal.setBreed(animal.getClass().getSimpleName() + "_" + ((int) (Math.random() * 10)));

        return animal;
    }

    private static AnimalFactory createByType() {
        AnimalType rType = AnimalType.getRandomType();
        switch (rType) {
            case BEAR:
                return new BearFactory();
            case WOLF:
                return new WolfFactory();
            case CAT:
                return new CatFactory();
            case PARROT:
                return new ParrotFactory();
            default:
                throw new RuntimeException(rType + "is unknown type");
        }
    }
}