package ru.mts.homework4.domain.abstraction;

import ru.mts.homework4.domain.enums.BreedType;

public interface HasBreedType {

    <E extends BreedType<String>> E getBreedType();

    Class<?> getEnumClass();

}
