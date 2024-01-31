package ru.mts.homework4.factory;


import org.apache.commons.lang3.StringUtils;
import ru.mts.homework4.domain.abstraction.Animal;
import ru.mts.homework4.domain.abstraction.HasBreedType;
import ru.mts.homework4.domain.enums.AnimalType;
import ru.mts.homework4.domain.enums.CharacterType;
import ru.mts.homework4.domain.enums.NameType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RandomAnimalFactory implements AnimalFactory {

    private final AnimalAbstractFactory animalAbstractFactory;

    public RandomAnimalFactory(AnimalAbstractFactory animalAbstractFactory) {
        this.animalAbstractFactory = animalAbstractFactory;
    }

    @Override
    public Animal createAnimal() {
        AnimalFactory animalFactory = animalAbstractFactory.createAnimalFactory(AnimalType.getRandomType());
        Animal animal = animalFactory.createAnimal();

        animal.setBirthDate(RandomDateProvider.createRandomDate());
        animal.setName(NameType.getRandomName());
        animal.setCost(BigDecimal.valueOf(Math.random() * 10000).setScale(2, RoundingMode.HALF_UP));
        animal.setCharacter(CharacterType.randomCharacter());
        if (animal instanceof HasBreedType) {
            var breed = getBreedType((HasBreedType) animal);
            animal.setBreed(breed);
        }

        return animal;
    }

    private String getBreedType(HasBreedType hasBreedType) {
        var enumClass = hasBreedType.getEnumClass();
        var values = enumClass.getFields();

        var type = values[0].getName();
        type = StringUtils.swapCase(type);
        type = StringUtils.capitalize(type);

        return type;
    }

}
