package ru.mts.homework3.domain.abstraction;

import java.math.BigDecimal;

public interface Animal {

    /**
     * Метод getBreed используется для получение
     * породы животного
     */
    String getBreed();

    /**
     * Метод getName используется для получение
     * имени животного
     */
    String getName();

    /**
     * Метод getCost используется для получение
     * цены животного
     */
    BigDecimal getCost();

    /**
     * Метод getCharacter используется для получение
     * характера животного
     */
    String getCharacter();

}
