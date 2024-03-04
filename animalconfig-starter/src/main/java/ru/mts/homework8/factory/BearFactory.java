package ru.mts.homework8.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mts.homework8.config.AnimalProperties;
import ru.mts.homework8.domain.Bear;

@Component
public class BearFactory implements AnimalFactory {

    private AnimalProperties animalProperties;

    @Autowired
    public void setAnimalProperties(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @Override
    public Bear createAnimal() {
        Bear bear = new Bear();
        bear.setName(RandomNameProvider.chooseRandomName(animalProperties.getBearNames()));
        return bear;
    }
}
