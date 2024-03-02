package ru.mts.homework7.factory;

import org.springframework.stereotype.Component;
import ru.mts.homework7.domain.Parrot;
@Component
public class ParrotFactory implements AnimalFactory {
    @Override
    public Parrot createAnimal() {
        return new Parrot();
    }
}
