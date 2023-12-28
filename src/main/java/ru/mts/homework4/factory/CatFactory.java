package ru.mts.homework4.factory;

import ru.mts.homework4.domain.Cat;
import ru.mts.homework4.domain.abstraction.Animal;

public class CatFactory implements AnimalFactory{
    @Override
    public Animal createAnimalF() {
        return new Cat();
    }
}
