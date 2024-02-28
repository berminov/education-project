package ru.mts.homework6.factory;

import ru.mts.homework6.domain.Bear;

public class BearFactory implements AnimalFactory {

    @Override
    public Bear createAnimal() {
        return new Bear();
    }

}
