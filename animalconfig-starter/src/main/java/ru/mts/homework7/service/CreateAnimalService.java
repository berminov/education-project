package ru.mts.homework7.service;

import ru.mts.homework7.domain.abstraction.Animal;

import java.util.List;

public interface CreateAnimalService {

    void setAnimalType(String type);

    String getAnimalType();

    /**
     * Метод createTenAnimal создаёт n животных, используя цикл while
     */

    List<Animal> createAnimals(int n);
}
