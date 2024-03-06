package ru.mts.homework9.apptest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mts.homework9.domain.Bear;
import ru.mts.homework9.domain.Cat;
import ru.mts.homework9.domain.Parrot;
import ru.mts.homework9.domain.abstraction.AbstractAnimal;
import ru.mts.homework9.domain.abstraction.Animal;
import ru.mts.homework9.repository.AnimalsRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AnimalsRepositoryTest {

    @Autowired
    AnimalsRepositoryImpl animalsRepository;

    private final static Map<String, List<Animal>> animals = new HashMap<>();
    private final static List<Animal> bears = new ArrayList<>();
    private final static List<Animal> cats = new ArrayList<>();
    private final static List<Animal> parrots = new ArrayList<>();

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
        animal1.setCost(BigDecimal.valueOf(10));

        animal2.setBirthDate(LocalDate.of(2024, 12, 12));
        animal2.setName("Ginger");
        animal2.setCharacter("Angry");
        animal2.setBreed("Black");
        animal2.setCost(BigDecimal.valueOf(20));

        animal3.setBirthDate(LocalDate.of(2017, 12, 12));
        animal3.setName("Haley");
        animal3.setCharacter("Neutral");
        animal3.setBreed("Orange");
        animal3.setCost(BigDecimal.valueOf(30));

        twin.setBirthDate(LocalDate.of(2017, 12, 12));
        twin.setName("Haley");
        twin.setCharacter("Neutral");
        twin.setBreed("Orange");
        twin.setCost(BigDecimal.valueOf(30));

        bears.add(animal1);
        parrots.add(animal2);
        cats.add(animal3);
        cats.add(twin);

        animals.put("Bear", bears);
        animals.put("Parrot", parrots);
        animals.put("Cat", cats);

    }

    /**
     * Тест findOlderAnimalsTest тестирует правильность работы метода
     * findOlderAnimals
     */
    @Test
    void findOlderAnimalsTest() {
        animalsRepository.setAnimals(animals);
        Map<Animal, Integer> expected = new HashMap<>();
        int age = 10;
        expected.put(animal1, Period.between(animal1.getBirthDate(), LocalDate.now()).getYears());
        Map<Animal, Integer> result = animalsRepository.findOlderAnimals(age);
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
     * Тест findNoOlderAnimalsTest тестирует работу метода
     * findOlderAnimals при отсутсвии животных старше заданного возраста
     */
    @Test
    void findNoOlderAnimalsTest() {
        animalsRepository.setAnimals(animals);
        Map<Animal, Integer> expected = new HashMap<>();
        int age = 1000;
        expected.put(animal1, Period.between(animal1.getBirthDate(), LocalDate.now()).getYears());
        Map<Animal, Integer> result = animalsRepository.findOlderAnimals(age);
        assertEquals(expected, result);
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
        Map<String, List<Animal>> expected = new HashMap<>();
        expected.put("Cat", List.of(twin));

        Map<String, List<Animal>> result = animalsRepository.findDuplicates();

        assertEquals(expected, result);
    }

    /**
     * Тест findLeapYearNamesTest тестирует правильность работы метода
     * findLeapYearNames
     */
    @Test
    void findLeapYearNamesTest() {
        animalsRepository.setAnimals(animals);
        Map<String, LocalDate> expected = new HashMap<>();
        expected.put("Bear Rudolph", LocalDate.of(2000, 12, 12));
        expected.put("Parrot Ginger", LocalDate.of(2024, 12, 12));

        Map<String, LocalDate> result = animalsRepository.findLeapYearNames();

        assertEquals(expected, result);
    }

    /**
     * Тест findAveragePriceTest тестирует правильность работы метода
     * findAveragePrice
     */
    @Test
    void findAveragePriceTest() {
        animalsRepository.setAnimals(animals);
        BigDecimal expected = new BigDecimal("22.50");
        BigDecimal result = animalsRepository.findAveragePrice();
        assertEquals(expected, result);
    }

    /**
     * Тест findAverageAgeTest тестирует правильность работы метода
     * findAverageAge
     */
    @Test
    void findAverageAgeTest() {
        animalsRepository.setAnimals(animals);
        double expected = 8.75;
        double result = animalsRepository.findAverageAge();
        assertEquals(expected, result);
    }
}
