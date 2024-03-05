package ru.mts.homework9.service;

import ru.mts.homework9.domain.abstraction.Animal;

import java.util.List;
import java.util.Map;

public interface CreateAnimalService {

    void setAnimalType(String type);

    String getAnimalType();

    /**
     * Метод createTenAnimal создаёт n животных, используя цикл while
     */

    Map<String, List<Animal>> createAnimals(int n);
}
