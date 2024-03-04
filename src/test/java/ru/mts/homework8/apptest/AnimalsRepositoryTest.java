package ru.mts.homework8.apptest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mts.homework8.domain.Bear;
import ru.mts.homework8.domain.Cat;
import ru.mts.homework8.domain.Parrot;
import ru.mts.homework8.domain.abstraction.AbstractAnimal;
import ru.mts.homework8.domain.abstraction.Animal;
import ru.mts.homework8.repository.AnimalsRepositoryImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AnimalsRepositoryTest {

    @Autowired
    AnimalsRepositoryImpl animalsRepository;

    private final static List<Animal> animals = new ArrayList<>();

    private final static AbstractAnimal animal1 = new Bear();

    private final static AbstractAnimal animal2 = new Parrot();

    private final static AbstractAnimal animal3 = new Cat();

    private final static AbstractAnimal twin = new Cat();

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

    /**
     * Тест findOlderAnimalsTest тестирует правильность работы метода
     * findOlderAnimals
     */
    @Test
    void findOlderAnimalsTest() {
        animalsRepository.setAnimals(animals);
        List<Animal> expected = new ArrayList<>();
        int age = 10;
        expected.add(animal1);
        List<Animal> result = animalsRepository.findOlderAnimals(age);
        assertEquals(expected, result);
    }

    /**
     * Тест findOlderAnimalsNegativeTest тестирует работу метода
     * findOlderAnimals при передаче ему отрицательного значения
     */
    @Test
    void findOlderAnimalsNegativeTest() {
        animalsRepository.setAnimals(animals);
        int negativeAge = -10;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    animalsRepository.findOlderAnimals(negativeAge);
                });

        assertEquals("Age can't be negative", exception.getMessage());
    }

    /**
     * Тест isContainsOlderAnimalsNegativeTest тестирует работу метода
     * isContainsOlderAnimals при передаче ему отрицательного значения
     */
    @Test
    void isContainsOlderAnimalsNegativeTest() {
        animalsRepository.setAnimals(animals);
        int negativeAge = -10;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    animalsRepository.isContainsOlderAnimals(negativeAge);
                });

        assertEquals("Age can't be negative", exception.getMessage());
    }

    /**
     * Тест findDuplicatesTest тестирует правильность работы метода
     * findDuplicates
     */
    @Test
    void findDuplicatesTest() {
        animalsRepository.setAnimals(animals);
        List<Animal> expected = new ArrayList<>();
        expected.add(twin);

        List<Animal> result = animalsRepository.findDuplicates();

        assertEquals(expected, result);
    }

    /**
     * Тест findLeapYearNamesTest тестирует правильность работы метода
     * findLeapYearNames
     */
    @Test
    void findLeapYearNamesTest() {
        animalsRepository.setAnimals(animals);
        List<String> expected = new ArrayList<>();
        expected.add(animal1.getName());
        expected.add(animal2.getName());

        List<String> result = animalsRepository.findLeapYearNames();

        assertEquals(expected, result);
    }
}
