package ru.mts.homework6.domain;

import ru.mts.homework6.domain.abstraction.HasBreedType;
import ru.mts.homework6.domain.abstraction.Pet;
import ru.mts.homework6.domain.enums.CatBreed;

public class Cat extends Pet implements HasBreedType {

    @Override
    public void whatLikes() {
        System.out.println(name + " like to sleep");
    }

    public void plays() {
        System.out.println(name + " plays with a ball");
    }

    @Override
    public void sound() {
        System.out.println("meow");
    }

    @Override
    public CatBreed getBreedType() {
        return CatBreed.fromBreed(breed);
    }

    @Override
    public Class<?> getEnumClass() {
        return CatBreed.class;
    }

}
