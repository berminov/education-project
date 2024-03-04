package ru.mts.homework8.domain.enums;

public interface BreedType<T> {

    T getBreedType();

    Class<?> getEnumClass();

}
