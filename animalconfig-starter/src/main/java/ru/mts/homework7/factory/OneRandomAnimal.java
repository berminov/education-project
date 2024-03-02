package ru.mts.homework7.factory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.homework7.config.AnimalProperties;
import ru.mts.homework7.domain.abstraction.Animal;
import ru.mts.homework7.domain.enums.AnimalType;
import ru.mts.homework7.domain.enums.CharacterType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
@Component
public class OneRandomAnimal {

    @Autowired
    private  AnimalProperties animalProperties;

    public Animal createAnimal(String name) {

        AnimalFactory animalFactory = createByType();
        Animal animal = animalFactory.createAnimal();


        System.out.println(Arrays.toString(animalProperties.getBearNames()));

        animal.setBirthDate(RandomDateProvider.createRandomDate());
        animal.setName(name);
        animal.setCost(BigDecimal.valueOf(Math.random() * 10000).setScale(2, RoundingMode.HALF_UP));
        animal.setCharacter(CharacterType.randomCharacter());
        animal.setBreed(animal.getClass().getSimpleName() + "_" + ((int) (Math.random() * 10)));

        return animal;
    }

    @Autowired
    private BearFactory bearFactory;

    private AnimalFactory createByType() {
        AnimalType rType = AnimalType.getRandomType();
        switch (rType) {
            case BEAR:
                return bearFactory;
            case WOLF:
                return new WolfFactory();
            case CAT:
                return new CatFactory();
            case PARROT:
                return new ParrotFactory();
            default:
                throw new RuntimeException(rType + "is unknown type");
        }
    }
}