package ru.mts.homework11.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.homework11.config.AnimalProperties;
import ru.mts.homework11.domain.Cat;

@Component
public class CatFactory implements AnimalFactory {

    private AnimalProperties animalProperties;

    @Autowired
    public void setAnimalProperties(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @Override
    public Cat createAnimal() {
        var cat = new Cat();
        cat.setName(RandomNameProvider.chooseRandomName(animalProperties.getCatNames()));

        return cat;
    }

}
