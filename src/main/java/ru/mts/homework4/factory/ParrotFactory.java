package ru.mts.homework4.factory;

import ru.mts.homework4.domain.Parrot;
import ru.mts.homework4.domain.abstraction.Animal;

public class ParrotFactory implements AnimalFactory {
    @Override
    public Animal createAnimalF() {
        return new Parrot();
    }
}
