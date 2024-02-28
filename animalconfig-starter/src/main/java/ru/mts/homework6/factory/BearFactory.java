package ru.mts.homework6.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mts.homework6.domain.Bear;
@Component
public class BearFactory implements AnimalFactory {

    @Override
    public Bear createAnimal() {
        return new Bear();
    }

}
