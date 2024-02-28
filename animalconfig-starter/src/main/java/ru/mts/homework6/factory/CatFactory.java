package ru.mts.homework6.factory;

import ru.mts.homework6.domain.Cat;

public class CatFactory implements AnimalFactory {

    @Override
    public Cat createAnimal() {
        return new Cat();
    }

}
