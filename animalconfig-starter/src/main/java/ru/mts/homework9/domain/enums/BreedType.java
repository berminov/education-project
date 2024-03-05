package ru.mts.homework9.domain.enums;

public interface BreedType<T> {

    T getBreedType();

    Class<?> getEnumClass();

}
