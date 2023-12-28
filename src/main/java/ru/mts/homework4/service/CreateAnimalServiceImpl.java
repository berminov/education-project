package ru.mts.homework4.service;

import ru.mts.homework4.domain.abstraction.Animal;
import ru.mts.homework4.factory.OneRandomAnimal;

import java.util.ArrayList;
import java.util.List;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    /**
     * Методо createTenAnimals переопределяет default метод интерфейса
     * CreateAnimalService
     */
    @Override
    public List<Animal> createTenAnimals() {
        List<Animal> animalArray = new ArrayList<>();
        int i = 0;
        do {
            OneRandomAnimal oneRandomAnimal = new OneRandomAnimal();
            animalArray.add(oneRandomAnimal.creation());
            i++;
        } while (i < 10);
        return animalArray;
    }

    /**
     * Метод createNAnimal создаёт n уникальных животных
     */
    public List<Animal> createNAnimal(int n) {
        List<Animal> animalArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " animal:");
            OneRandomAnimal oneRandomAnimal = new OneRandomAnimal();
            animalArray.add(oneRandomAnimal.creation());

        }
        return animalArray;
    }

    /**
     * В случае, если параметр n, не был передан метод createNAnimal создает
     * одно уникальное животное
     */
    public List<Animal> createNAnimal() {
        List<Animal> animalArray = new ArrayList<>();
        OneRandomAnimal oneRandomAnimal = new OneRandomAnimal();
        animalArray.add(oneRandomAnimal.creation());
        return animalArray;
    }
}
