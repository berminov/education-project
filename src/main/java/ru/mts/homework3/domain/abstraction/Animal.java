package ru.mts.homework3.domain.abstraction;

import java.math.BigDecimal;

public interface Animal {

    /**
     * Метод getBreed используется для получение
     * породы животного
     */
    String getBreed();
    void setBreed(String breed);

    /**
     * Метод getName используется для получение
     * имени животного
     */
    String getName();
    void setName(String name);

    /**
     * Метод getCost используется для получение
     * цены животного
     */
    BigDecimal getCost();

    void setCost(BigDecimal cost);

    /**
     * Метод getCharacter используется для получение
     * характера животного
     */
    String getCharacter();

    void setCharacter(String character);

    void sound();

}
