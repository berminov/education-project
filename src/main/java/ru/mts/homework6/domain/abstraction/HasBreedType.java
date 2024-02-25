package ru.mts.homework6.domain.abstraction;

import ru.mts.homework6.domain.enums.BreedType;

public interface HasBreedType {

    <E extends BreedType<String>> E getBreedType();

    Class<?> getEnumClass();

}
