package ru.mts.homework11.domain.enums;

public interface BreedType<T> {

    T getBreedType();

    Class<?> getEnumClass();

}
