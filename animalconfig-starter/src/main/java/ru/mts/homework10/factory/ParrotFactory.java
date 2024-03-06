package ru.mts.homework10.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.homework10.config.AnimalProperties;
import ru.mts.homework10.domain.Parrot;

@Component
public class ParrotFactory implements AnimalFactory {

    private AnimalProperties animalProperties;
    @Autowired
    public void setAnimalProperties(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @Override
    public Parrot createAnimal() {
        Parrot parrot = new Parrot();
        parrot.setName(RandomNameProvider.chooseRandomName(animalProperties.getParrotNames()));
        return parrot;
    }
}
