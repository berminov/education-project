package ru.mts.homework3.factory;

import ru.mts.homework3.domain.Parrot;
import ru.mts.homework3.domain.abstraction.Animal;

public class ParrotFactory implements AnimalFactory{
    @Override
    public Animal createAnimalF() {
        return new Parrot();
    }
}
