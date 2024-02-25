package ru.mts.homework6.service;

import ru.mts.homework6.domain.abstraction.Animal;
import ru.mts.homework6.factory.OneRandomAnimal;

import java.util.ArrayList;
import java.util.List;

public interface CreateAnimalService {

    /**
     * Метод createTenAnimal создаёт 10 животных, используя цикл while
     */
    default List<Animal> createTenAnimals() {

        List<Animal> result = new ArrayList<>();

        int i = 0;
        while (i < 10) {
            result.add(OneRandomAnimal.createAnimal());
            i++;
        }

        return result;
    }

    final class AnimalFactoryProvider {

        private AnimalFactoryProvider() {
        }
    }
}
