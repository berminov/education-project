package ru.mts.homework3.factory;

import ru.mts.homework3.domain.Cat;
import ru.mts.homework3.domain.abstraction.Animal;

public class CatFactory implements AnimalFactory{
    @Override
    public Animal createAnimalF() {
        return new Cat();
    }
}
