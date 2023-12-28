package ru.mts.homework4.factory;


import ru.mts.homework4.domain.abstraction.Animal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OneRandomAnimal {
    public Animal creation() {
        AnimalFactory animalFactory = createByType();
        Animal animal = animalFactory.createAnimalF();

        animal.setBirthDate(RandomDate.setRandomDate());

        animal.setName(NameTypes.randomName());

        animal.setCost(BigDecimal.valueOf(Math.random() * 10000).setScale(2, RoundingMode.HALF_UP));

        animal.setCharacter(CharacterTypes.randomCharacter());

        animal.setBreed(animal.getClass().getSimpleName() + "_" + ((int) (Math.random() * 10)));

        return animal;
    }

    private AnimalFactory createByType() {
        AnimalTypes rType = AnimalTypes.getRandomType();
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
