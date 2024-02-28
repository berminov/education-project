package ru.mts.homework7.factory;

import ru.mts.homework7.domain.Wolf;

public class WolfFactory implements AnimalFactory {

    @Override
    public Wolf createAnimal() {
        return new Wolf();
    }
}
