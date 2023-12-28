package ru.mts.homework4.factory;

import ru.mts.homework4.domain.Wolf;

public class WolfFactory implements AnimalFactory {

    @Override
    public Wolf createAnimal() {
        return new Wolf();
    }

}
