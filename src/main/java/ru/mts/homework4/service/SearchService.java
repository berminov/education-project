package ru.mts.homework4.service;

import ru.mts.homework4.domain.abstraction.Animal;

import java.util.List;

public interface SearchService {
    /**
     * Метод findLeapYear возвращается имена животных
     * с високосным годом рождения
     */
    List<String> findLeapYearNames(List<Animal> animal);

    /**
     * Метод findOlderAnimals возращает массив животных
     * старше определенного возраста
     */
    List<Animal> findOlderAnimals(List<Animal> animal, int n);

    /**
     * Метод findDuplicates выводит дупликаты животных
     */
    void findDuplicates(List<Animal> animal);

    /**
     * Метод checkLeapYears проверяет, есть ли
     * в массиве животные с високосным годом рождения
     */
    boolean checkLeapYears(List<Animal> animal);

    /**
     * Метод checkOlderAnimals проверяет, есть ли
     * в массиве животные старше определенного
     * возраста
     */
    boolean checkOlderAnimals(List<Animal> animal, int n);

    /**
     * Метод checkDuplicates проверяет, есть ли
     * в массиве дупликаты
     */
    boolean checkDuplicates(List<Animal> animal);
}
