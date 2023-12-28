package ru.mts.homework4.service;

import ru.mts.homework4.domain.abstraction.Animal;
import ru.mts.homework4.factory.AnimalFactory;
import ru.mts.homework4.factory.RandomAnimalFactory;
import ru.mts.homework4.factory.ReflectionAnimalAbstractFactory;

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
