package ru.mts.homework4.factory;

import ru.mts.homework4.domain.enums.AnimalType;

public interface AnimalAbstractFactory {

    AnimalFactory createAnimalFactory(AnimalType animalType);

}
