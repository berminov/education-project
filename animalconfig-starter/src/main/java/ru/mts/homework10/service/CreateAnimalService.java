package ru.mts.homework10.service;

import ru.mts.homework10.domain.abstraction.Animal;

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
