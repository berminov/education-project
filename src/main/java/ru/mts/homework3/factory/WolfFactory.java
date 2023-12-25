package ru.mts.homework3.factory;

import ru.mts.homework3.domain.Wolf;
import ru.mts.homework3.domain.abstraction.Animal;

public class WolfFactory implements AnimalFactory{
    @Override
    public Animal createAnimalF() {
        return new Wolf();
    }
}
