package ru.mts.homework4.service;

import ru.mts.homework4.domain.abstraction.Animal;
import ru.mts.homework4.factory.OneRandomAnimal;

import java.util.ArrayList;
import java.util.List;

public interface CreateAnimalService {

    /**
     * Метод createTenAnimal создаёт 10 животных, используя цикл while
     */
    default List<Animal> createTenAnimals() {
        List<Animal> animalArray = new ArrayList<>();
        int i = 0;
        while (i < 10) {
            OneRandomAnimal oneRandomAnimal = new OneRandomAnimal();
            animalArray.add(oneRandomAnimal.creation());
            i++;
        }
        return  animalArray;
    }
}
