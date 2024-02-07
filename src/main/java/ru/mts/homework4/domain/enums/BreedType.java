package ru.mts.homework4.domain.enums;

public interface BreedType<T> {

    T getBreedType();

    Class<?> getEnumClass();

}
