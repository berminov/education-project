package ru.mts.homework6.service;

import ru.mts.homework6.domain.abstraction.Animal;
import ru.mts.homework6.factory.AnimalFactory;
import ru.mts.homework6.factory.RandomAnimalFactory;
import ru.mts.homework6.factory.ReflectionAnimalAbstractFactory;

import java.util.ArrayList;
import java.util.List;

public interface CreateAnimalService {

    /**
     * Метод createTenAnimal создаёт 10 животных, используя цикл while
     */
    default List<Animal> createTenAnimals() {

        var animalFactory = AnimalFactoryProvider.createAnimalFactory();

        List<Animal> result = new ArrayList<>();

        int i = 0;
        while (i < 10) {
            result.add(animalFactory.createAnimal());
            i++;
        }

        return result;
    }

    final class AnimalFactoryProvider {

        private AnimalFactoryProvider() {
        }

        public static AnimalFactory createAnimalFactory() {
            return new RandomAnimalFactory(new ReflectionAnimalAbstractFactory());
        }
    }
}
