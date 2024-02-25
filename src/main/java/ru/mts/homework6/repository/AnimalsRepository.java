package ru.mts.homework6.repository;

import ru.mts.homework6.domain.abstraction.Animal;

import java.util.List;

public interface AnimalsRepository {

    /**
     * Метод findLeapYear возвращается имена животных
     * с високосным годом рождения
     */
    List<String> findLeapYearNames();

    /**
     * Метод findOlderAnimals возвращает массив животных
     * старше определенного возраста
     */
    List<Animal> findOlderAnimals(int n);

    /**
     * Метод findDuplicates выводит дубликаты животных
     */
    List<Animal> findDuplicates();

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

    void printDuplicates();

    void setAnimals(List<Animal> animals);
}
