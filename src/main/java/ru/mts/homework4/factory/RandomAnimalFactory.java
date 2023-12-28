package ru.mts.homework4.factory;


import ru.mts.homework4.domain.abstraction.Animal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RandomAnimalFactory implements AnimalFactory {

    private final AnimalAbstractFactory animalAbstractFactory;

    public RandomAnimalFactory(AnimalAbstractFactory animalAbstractFactory) {
        this.animalAbstractFactory = animalAbstractFactory;
    }

    @Override
    public Animal createAnimal() {
        AnimalFactory animalFactory = animalAbstractFactory.createAnimalFactory(AnimalType.getRandomType());
        Animal animal = animalFactory.createAnimal();

        animal.setBirthDate(RandomDateProvider.createRandomDate());
        animal.setName(NameType.getRandomName());
        animal.setCost(BigDecimal.valueOf(Math.random() * 10000).setScale(2, RoundingMode.HALF_UP));
        animal.setCharacter(CharacterType.randomCharacter());
        animal.setBreed(animal.getClass().getSimpleName() + "_" + ((int) (Math.random() * 10)));

        return animal;
    }


}
