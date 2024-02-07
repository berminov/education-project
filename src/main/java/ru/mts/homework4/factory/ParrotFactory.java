package ru.mts.homework4.factory;

import ru.mts.homework4.domain.Parrot;

public class ParrotFactory implements AnimalFactory {

    @Override
    public Parrot createAnimal() {
        return new Parrot();
    }

}
