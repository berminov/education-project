package ru.mts.homework7.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mts.homework7.domain.abstraction.Animal;
import ru.mts.homework7.factory.OneRandomAnimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

        List<Animal> animalArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            animalArray.add(oneRandomAnimal.createAnimal());
        }
        return animalArray;
    }
}
