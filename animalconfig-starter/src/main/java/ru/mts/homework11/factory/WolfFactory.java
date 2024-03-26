package ru.mts.homework11.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.homework11.config.AnimalProperties;
import ru.mts.homework11.domain.Wolf;

@Component
public class WolfFactory implements AnimalFactory {

    private AnimalProperties animalProperties;

    @Autowired
    public void setAnimalProperties(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @Override
    public Wolf createAnimal() {
        var wolf = new Wolf();
        wolf.setName(RandomNameProvider.chooseRandomName(animalProperties.getWolfNames()));

        return wolf;
    }

}
