package ru.mts.homework10.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mts.homework10.domain.abstraction.Animal;
import ru.mts.homework10.factory.OneRandomAnimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, List<Animal>> createAnimals(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Number of animals should be positive");
        }

        List<Animal> animalArray = new ArrayList<>();

        List<Animal> bearList = new ArrayList<>();
        List<Animal> catList = new ArrayList<>();
        List<Animal> parrotList = new ArrayList<>();
        List<Animal> wolfList = new ArrayList<>();

        Map<String, List<Animal>> animalMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Animal animal = oneRandomAnimal.createAnimal();
            switch (animal.getClass().getSimpleName()) {
                case "Bear":
                    bearList.add(animal);
                    break;
                case "Cat":
                    catList.add(animal);
                    break;
                case "Parrot":
                    parrotList.add(animal);
                    break;
                case "Wolf":
                    wolfList.add(animal);
                    break;
            }
        }

        animalMap.put("Bear", bearList);
        animalMap.put("Cat", catList);
        animalMap.put("Parrot", parrotList);
        animalMap.put("Wolf", wolfList);

        return animalMap;
    }
}
