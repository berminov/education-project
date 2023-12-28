package ru.mts.homework4.factory;

import ru.mts.homework4.domain.Bear;
import ru.mts.homework4.domain.abstraction.Animal;

public class BearFactory implements AnimalFactory {
    @Override
    public Animal createAnimalF() {
        return new Bear();
    }
}
