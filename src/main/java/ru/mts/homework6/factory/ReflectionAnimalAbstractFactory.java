package ru.mts.homework6.factory;

import ru.mts.homework6.domain.enums.AnimalType;
import ru.mts.homework6.utils.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class ReflectionAnimalAbstractFactory implements AnimalAbstractFactory {

    @Override
    public AnimalFactory createAnimalFactory(AnimalType animalType) {
        Preconditions.checkArgument(Objects.nonNull(animalType), "'animalType' is null");

        try {
            return animalType.getFactoryClass()
                    .getDeclaredConstructor()
                    .newInstance();

        } catch (InstantiationException
                 | IllegalAccessException
                 | InvocationTargetException
                 | NoSuchMethodException e) {

            throw new RuntimeException(e);
        }
    }
}
