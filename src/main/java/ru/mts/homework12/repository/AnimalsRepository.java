package ru.mts.homework12.repository;

import ru.mts.homework12.domain.abstraction.Animal;
import ru.mts.homework12.exceptions.AnimalsArraySizeException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalsRepository {

    /**
     * Метод findLeapYear возвращается имена животных
     * с високосным годом рождения
     */
    Map<String, LocalDate> findLeapYearNames();

    /**
     * Метод findOlderAnimals возвращает массив животных
     * старше определенного возраста
     */
    Map<Animal, Integer> findOlderAnimals(int n);

    /**
     * Метод findDuplicates выводит дубликаты животных
     */
    Map<String, List<Animal>> findDuplicates();

    /**
     * Метод isBirthDateAnimalLeapYear проверяет, является ли
     * год рождения животного високосным
     */
    boolean isBirthDateAnimalLeapYear(Animal animal);

    /**
     * Метод isContainsOlderAnimals проверяет, есть ли
     * в списке животные старше определенного
     * возраста
     */
    boolean isContainsOlderAnimals(int n);

    /**
     * Метод isContainsDuplicates проверяет, есть ли
     * в списке дубликаты
     */
    boolean isContainsDuplicates();

    /**
     * Метод printDuplicates выводит дубликаты
     */
    void printDuplicates();

    /**
     * Метод setAnimals устанавливает животных
     */
    void setAnimals(Map<String, List<Animal>> animals);

    /**
     * Метод findAverageAge возвращает средний возраст всех животных
     */
    double findAverageAge();

    /**
     * Метод findAveragePrice возвращает среднюю цену всех животных
     */
    BigDecimal findAveragePrice();

    /**
     * Метод findOldAndExpensive возвращает животных, которые
     * старше пяти лет и дороже средней цены, в порядке возрастания
     * даты рождения
     */
    List<Animal> findOldAndExpensive();

    /**
     * Метод findMinConstAnimals возвращает имена, трех самых дешевых
     * животных в обратном алфавитном порядке
     */
    List<String> findMinConstAnimals() throws AnimalsArraySizeException;
}
