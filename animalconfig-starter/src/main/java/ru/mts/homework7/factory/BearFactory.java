package ru.mts.homework7.factory;

import ru.mts.homework7.domain.Bear;

public class BearFactory implements AnimalFactory {
    @Override
    public Bear createAnimal() {
        return new Bear();
    }
}
