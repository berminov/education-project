package ru.mts.homework4.factory;

import ru.mts.homework4.utils.Preconditions;

import java.util.Objects;

public class ManualAnimalAbstractFactory implements AnimalAbstractFactory {

    @Override
    public AnimalFactory createAnimalFactory(AnimalType animalType) {
        Preconditions.checkArgument(Objects.nonNull(animalType), "'animalType' is null");

        switch (animalType) {
            case BEAR:
                return new BearFactory();
            case WOLF:
                return new WolfFactory();
            case CAT:
                return new CatFactory();
            case PARROT:
                return new ParrotFactory();
            default:
                throw new RuntimeException(String.format("%s is unknown type", animalType));
        }

    }

}
