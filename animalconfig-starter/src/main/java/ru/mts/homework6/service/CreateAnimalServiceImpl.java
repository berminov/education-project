package ru.mts.homework6.service;

import org.springframework.beans.factory.annotation.Value;
import ru.mts.homework6.domain.abstraction.Animal;
import ru.mts.homework6.factory.OneRandomAnimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Value("${names.bear}")
    private String[] names;

    private String animalType;

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
            animalArray.add(OneRandomAnimal.createAnimal(getRandomName(names)));
        }
        return animalArray;
    }

    public static String getRandomName(String[] names) {
        Random random = new Random();
        int randomIndex = random.nextInt(names.length);
        return names[randomIndex];
    }
}
