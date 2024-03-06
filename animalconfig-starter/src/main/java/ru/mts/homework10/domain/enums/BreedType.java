package ru.mts.homework10.domain.enums;

public interface BreedType<T> {

    T getBreedType();

    Class<?> getEnumClass();

}
