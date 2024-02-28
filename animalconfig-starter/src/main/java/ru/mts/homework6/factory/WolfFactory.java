package ru.mts.homework6.factory;

import ru.mts.homework6.domain.Wolf;

public class WolfFactory implements AnimalFactory {

    @Override
    public Wolf createAnimal() {
        return new Wolf();
    }
}
