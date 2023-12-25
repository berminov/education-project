package ru.mts.homework3.factory;

import ru.mts.homework3.domain.Bear;
import ru.mts.homework3.domain.Cat;
import ru.mts.homework3.domain.Parrot;
import ru.mts.homework3.domain.Wolf;
import ru.mts.homework3.domain.abstraction.Animal;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static ru.mts.homework3.factory.AnimalTypes.WOLF;

public class OneRandomAnimal {
    public void creation() {
        AnimalFactory animalFactory = createByType();
        Animal animal = animalFactory.createAnimalF();
        System.out.println(animal);
    }
    private AnimalFactory createByType() {
        String rType = AnimalTypes.getRandomType();
        switch (rType) {
            case "BEAR":
                return new BearFactory();
            case "WOLF":
                return new WolfFactory();
            case "CAT":
                return new CatFactory();
            case "PARROT":
                return new ParrotFactory();
            default:
                throw new RuntimeException(rType + "is unknown type");
        }
    }
}
