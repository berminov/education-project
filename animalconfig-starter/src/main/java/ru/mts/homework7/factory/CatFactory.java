package ru.mts.homework7.factory;

import org.springframework.stereotype.Component;
import ru.mts.homework7.domain.Cat;
@Component
public class CatFactory implements AnimalFactory {
    @Override
    public Cat createAnimal() {
        return new Cat();
    }
}
