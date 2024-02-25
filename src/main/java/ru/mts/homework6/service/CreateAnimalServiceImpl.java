package ru.mts.homework6.service;

import ru.mts.homework6.domain.abstraction.Animal;
import ru.mts.homework6.factory.AnimalFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    private final AnimalFactory animalFactory;

    public CreateAnimalServiceImpl(AnimalFactory animalFactory) {
        this.animalFactory = animalFactory;
    }

    /**
     * Методо createTenAnimals переопределяет default метод интерфейса
     * CreateAnimalService
     */
    @Override
    public List<Animal> createTenAnimals() {
        List<Animal> animalArray = new ArrayList<>();

        int i = 0;
        do {
            animalArray.add(animalFactory.createAnimal());
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
            animalArray.add(animalFactory.createAnimal());
        }

        return animalArray;
    }

    /**
     * В случае, если параметр n, не был передан метод createNAnimal создает
     * одно уникальное животное
     */
    public List<Animal> createNAnimal() {
        return Collections.singletonList(animalFactory.createAnimal());
    }
}
