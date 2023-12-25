package ru.mts.homework3.service;

import ru.mts.homework3.factory.OneRandomAnimal;

public interface CreateAnimalService {

    /**
     * Метод createTenAnimal создаёт 10 животных, используя цикл while
     */
    default void createTenAnimals() {
        int i = 0;
        while (i < 10) {
            System.out.println(i + 1 + " animal:");
            OneRandomAnimal oneRandomAnimal = new OneRandomAnimal();
            oneRandomAnimal.creation();
            i++;
            System.out.println();
        }
    }

}
