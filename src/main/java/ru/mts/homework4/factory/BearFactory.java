package ru.mts.homework4.factory;

import ru.mts.homework4.domain.Bear;

public class BearFactory implements AnimalFactory {

    @Override
    public Bear createAnimal() {
        return new Bear();
    }

}
