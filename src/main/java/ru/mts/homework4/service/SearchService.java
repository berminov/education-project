package ru.mts.homework4.service;

import ru.mts.homework4.domain.abstraction.Animal;

import java.util.List;

public interface SearchService {

    /**
     * Метод findLeapYear возвращается имена животных
     * с високосным годом рождения
     */
    List<String> findLeapYearNames(List<Animal> animals);

    /**
     * Метод findOlderAnimals возвращает массив животных
     * старше определенного возраста
     */
    List<Animal> findOlderAnimals(List<Animal> animals, int n);

    /**
     * Метод findDuplicates выводит дубликаты животных
     */
    void findDuplicates(List<Animal> animals);

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
    boolean isContainsOlderAnimals(List<Animal> animals, int n);

    /**
     * Метод isContainsDuplicates проверяет, есть ли
     * в списке дубликаты
     */
    boolean isContainsDuplicates(List<Animal> animals);

}
