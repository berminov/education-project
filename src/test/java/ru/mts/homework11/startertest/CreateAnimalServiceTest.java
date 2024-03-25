package ru.mts.homework11.startertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.homework11.domain.Cat;
import ru.mts.homework11.domain.abstraction.Animal;
import ru.mts.homework11.service.CreateAnimalServiceImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = TestConfig.class)
@ActiveProfiles("test")
public class CreateAnimalServiceTest {

    @Autowired
    private CreateAnimalServiceImpl createAnimalService;

    /**
     * Тест createNegativeNumberOfAnimalsTest тестирует работу метода
     * createAnimals при передаче ему отрицательного значения
     */
    @Test
    void createNegativeNumberOfAnimalTest() {
        int negativeAge = -10;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> createAnimalService.createAnimals(negativeAge)
        );

        assertEquals("Number of animals should be positive", exception.getMessage());
    }

    /**
     * Тест createMultipleAnimalsTest тестирует правильность работы
     * метода createAnimals
     */
    @Test
    void createMultipleAnimalsTest() {
        int n = 10;
        var animals = createAnimalService.createAnimals(n);
        var entrySet = animals.entrySet();
        int actualSize = entrySet.size();

        assertEquals(n, actualSize);
    }

    /**
     * Тест setNegativePriceOfAnimalTest тестирует работу метода
     * setPrice при передаче ему отрицательного значения
     */
    @Test
    void setNegativePriceOfAnimalTest() {
        var negativePrice = BigDecimal.valueOf(-10);
        Animal animal = new Cat();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> animal.setCost(negativePrice)
        );

        assertEquals("Price of animal should be positive", exception.getMessage());
    }

}
