package ru.mts.homework7.factory;

import ru.mts.homework7.domain.Cat;

public class CatFactory implements AnimalFactory {

    @Override
    public Cat createAnimal() {
        return new Cat();
    }
}
