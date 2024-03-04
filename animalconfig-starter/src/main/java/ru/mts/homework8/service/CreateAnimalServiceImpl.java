package ru.mts.homework8.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mts.homework8.domain.abstraction.Animal;
import ru.mts.homework8.factory.OneRandomAnimal;

import java.util.ArrayList;
import java.util.List;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    private OneRandomAnimal oneRandomAnimal;
    private String animalType;
    @Autowired
    public void setOneRandomAnimal(OneRandomAnimal oneRandomAnimal) {
        this.oneRandomAnimal = oneRandomAnimal;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    /**
     * Метод createNAnimal создаёт n уникальных животных
     */
    public List<Animal> createAnimals(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Number of animals should be positive");
        }

        List<Animal> animalArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            animalArray.add(oneRandomAnimal.createAnimal());
        }
        return animalArray;
    }
}
