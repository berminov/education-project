package ru.mts.homework9.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.homework9.config.AnimalProperties;
import ru.mts.homework9.domain.Cat;

@Component
public class CatFactory implements AnimalFactory {

    private AnimalProperties animalProperties;

    @Autowired
    public void setAnimalProperties(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @Override
    public Cat createAnimal() {
        Cat cat = new Cat();
        cat.setName(RandomNameProvider.chooseRandomName(animalProperties.getCatNames()));
        return cat;
    }
}
