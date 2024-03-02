package ru.mts.homework7.factory;

import org.springframework.stereotype.Component;
import ru.mts.homework7.domain.Wolf;

@Component
public class WolfFactory implements AnimalFactory {
    @Override
    public Wolf createAnimal() {
        return new Wolf();
    }
}
