package ru.mts.homework9.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.homework9.config.AnimalProperties;
import ru.mts.homework9.domain.Wolf;

@Component
public class WolfFactory implements AnimalFactory {

    private AnimalProperties animalProperties;

    @Autowired
    public void setAnimalProperties(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @Override
    public Wolf createAnimal() {
        Wolf wolf = new Wolf();
        wolf.setName(RandomNameProvider.chooseRandomName(animalProperties.getWolfNames()));
        return wolf;
    }
}
