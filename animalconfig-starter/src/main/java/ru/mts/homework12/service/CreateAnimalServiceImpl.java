package ru.mts.homework12.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mts.homework12.domain.abstraction.Animal;
import ru.mts.homework12.factory.OneRandomAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    private OneRandomAnimal oneRandomAnimal;
    private String animalType;

    @Autowired
    public void setOneRandomAnimal(OneRandomAnimal oneRandomAnimal) {
        this.oneRandomAnimal = oneRandomAnimal;
    }

    @Override
    public String getAnimalType() {
        return animalType;
    }

    @Override
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    /**
     * Метод createNAnimal создаёт n уникальных животных
     */
    @Override
    public Map<String, List<Animal>> createAnimals(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of animals should be positive");
        }

        List<Animal> bears = new ArrayList<>();
        List<Animal> cats = new ArrayList<>();
        List<Animal> parrots = new ArrayList<>();
        List<Animal> wolfs = new ArrayList<>();

        Animal animal;
        for (int i = 0; i < n; i++) {
            animal = oneRandomAnimal.createAnimal();

            switch (animal.getClass().getSimpleName()) {
                case "Bear":
                    bears.add(animal);
                    break;
                case "Cat":
                    cats.add(animal);
                    break;
                case "Parrot":
                    parrots.add(animal);
                    break;
                case "Wolf":
                    wolfs.add(animal);
                    break;
            }

        }

        return Map.of(
                "Bear", bears,
                "Cat", cats,
                "Parrot", parrots,
                "Wolf", wolfs
        );
    }

}
