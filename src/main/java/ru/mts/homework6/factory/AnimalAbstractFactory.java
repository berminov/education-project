package ru.mts.homework6.factory;

import ru.mts.homework6.domain.enums.AnimalType;

public interface AnimalAbstractFactory {

    AnimalFactory createAnimalFactory(AnimalType animalType);

}
