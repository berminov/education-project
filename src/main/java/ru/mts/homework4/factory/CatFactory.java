package ru.mts.homework4.factory;

import ru.mts.homework4.domain.Cat;

public class CatFactory implements AnimalFactory {

    @Override
    public Cat createAnimal() {
        return new Cat();
    }

}
