package ru.mts.homework7.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mts.homework7.config.AnimalProperties;
import ru.mts.homework7.domain.abstraction.Animal;
import ru.mts.homework7.factory.AnimalFactory;
import ru.mts.homework7.factory.OneRandomAnimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    private AnimalProperties animalProperties;

    @Autowired
    public void setAnimalProperties(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

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

        System.out.println(Arrays.toString(animalProperties.getAllNames()));
        List<Animal> animalArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            animalArray.add(OneRandomAnimal.createAnimal(getRandomName(animalProperties.getAllNames())));
        }
        return animalArray;
    }

    public static String getRandomName(String[] names) {
        Random random = new Random();
        int randomIndex = random.nextInt(names.length);
        return names[randomIndex];
    }
}
