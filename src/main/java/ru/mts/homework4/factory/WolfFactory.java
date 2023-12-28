package ru.mts.homework4.factory;

import ru.mts.homework4.domain.Wolf;
import ru.mts.homework4.domain.abstraction.Animal;

public class WolfFactory implements AnimalFactory {
    @Override
    public Animal createAnimalF() {
        return new Wolf();
    }
}
