package ru.mts.homework4.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.homework4.domain.Bear;
import ru.mts.homework4.domain.Cat;
import ru.mts.homework4.domain.Parrot;
import ru.mts.homework4.domain.abstraction.AbstractAnimal;
import ru.mts.homework4.domain.abstraction.Animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchServiceImplTest {

    private final static SearchService search = new SearchServiceImpl();
    private final static List<Animal> animals = new ArrayList<>();
    ;
    private final static AbstractAnimal animal1 = new Bear();
    ;
    private final static AbstractAnimal animal2 = new Parrot();
    ;
    private final static AbstractAnimal animal3 = new Cat();
    ;
    private final static AbstractAnimal twin = new Cat();
    ;

    @BeforeAll
    public static void arrayCreation() {

        animal1.setBirthDate(LocalDate.of(2000, 12, 12));
        animal1.setName("Rudolph");
        animal1.setCharacter("Kind");
        animal1.setBreed("White");

        animal2.setBirthDate(LocalDate.of(2024, 12, 12));
        animal2.setName("Ginger");
        animal2.setCharacter("Angry");
        animal2.setBreed("Black");

        animal3.setBirthDate(LocalDate.of(2017, 12, 12));
        animal3.setName("Haley");
        animal3.setCharacter("Neutral");
        animal3.setBreed("Orange");

        twin.setBirthDate(LocalDate.of(2017, 12, 12));
        twin.setName("Haley");
        twin.setCharacter("Neutral");
        twin.setBreed("Orange");

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(twin);
    }

    @Test
    @DisplayName("Тест: вывод животных с високосным годом")
    void findLeapYearNamesTest() {

        List<String> expected = new ArrayList<>();
        expected.add(animal1.getName());
        expected.add(animal2.getName());

        List<String> result = search.findLeapYearNames(animals);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Тест: вывод имен старше заданного возраста")
    void findOlderAnimalsTest() {

        List<Animal> expected = new ArrayList<>();
        int age = 10;
        expected.add(animal1);

        List<Animal> result = search.findOlderAnimals(animals, age);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Тест: вывод дупликатов животных")
    void findDuplicatesTest() {

        List<Animal> expected = new ArrayList<>();
        expected.add(twin);

        List<Animal> result = search.findDuplicates(animals);

        assertEquals(expected, result);
    }
}