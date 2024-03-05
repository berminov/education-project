package ru.mts.homework9.repository;

import ru.mts.homework9.domain.abstraction.Animal;

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
    Map<String, Integer> findDuplicates();

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
}
