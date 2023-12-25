package ru.mts.homework3.factory;

import ru.mts.homework3.domain.Bear;
import ru.mts.homework3.domain.abstraction.Animal;

public class BearFactory implements AnimalFactory{
    @Override
    public Animal createAnimalF() {
        return new Bear();
    }
}
