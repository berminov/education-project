package ru.mts.homework9.domain.abstraction;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal {

    /**
     * Метод getBreed используется для получение
     * породы животного
     */
    String getBreed();

    /**
     * Метод setBreed используется для установки
     * породы животного
     */
    void setBreed(String breed);

    /**
     * Метод getName используется для получение
     * имени животного
     */
    String getName();

    /**
     * Метод setName используется для установки
     * имени животного
     */
    void setName(String name);

    /**
     * Метод getCost используется для получение
     * цены животного
     */
    BigDecimal getCost();

    /**
     * Метод setCost используется для установки
     * цены животного
     */
    void setCost(BigDecimal cost);

    /**
     * Метод getCharacter используется для получение
     * характера животного
     */
    String getCharacter();

    /**
     * Метод setCharacter используется для установки
     * характера животного
     */
    void setCharacter(String character);

    /**
     * Метод getBirthDate используется для получение
     * даты рождения животного
     */
    LocalDate getBirthDate();

    /**
     * Метод getBirthDate используется для установки
     * даты рождения животного
     */
    void setBirthDate(LocalDate birthDate);

    void sound();

}
