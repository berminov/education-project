package ru.mts.homework7.factory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.homework7.domain.abstraction.Animal;
import ru.mts.homework7.domain.enums.CharacterType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

@Component
public class OneRandomAnimal {

    private final List<AnimalFactory> factories;
    @Autowired
    public OneRandomAnimal(BearFactory bearFactory,
                           CatFactory catFactory,
                           ParrotFactory parrotFactory,
                           WolfFactory wolfFactory){
        this.factories = List.of(bearFactory, catFactory, parrotFactory, wolfFactory);
    }


    public Animal createAnimal() {

        AnimalFactory animalFactory = getRandomFabric(factories);

        Animal animal = animalFactory.createAnimal();

        animal.setBirthDate(RandomDateProvider.createRandomDate());
        animal.setCost(BigDecimal.valueOf(Math.random() * 10000).setScale(2, RoundingMode.HALF_UP));
        animal.setCharacter(CharacterType.randomCharacter());
        animal.setBreed(animal.getClass().getSimpleName() + "_" + ((int) (Math.random() * 10)));

        return animal;
    }

    public static AnimalFactory getRandomFabric(List<AnimalFactory> factories) {
        Random random = new Random();
        int randomIndex = random.nextInt(factories.size());
        return factories.get(randomIndex);
    }
}