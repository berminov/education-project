package ru.mts.homework7.factory;

import ru.mts.homework7.domain.Parrot;

public class ParrotFactory implements AnimalFactory {

    @Override
    public Parrot createAnimal() {
        return new Parrot();
    }
}
