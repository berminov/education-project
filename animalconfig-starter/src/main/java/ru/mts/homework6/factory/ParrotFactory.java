package ru.mts.homework6.factory;

import ru.mts.homework6.domain.Parrot;

public class ParrotFactory implements AnimalFactory {

    @Override
    public Parrot createAnimal() {
        return new Parrot();
    }

}
