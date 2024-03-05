package ru.mts.homework9.startertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.homework9.domain.Cat;
import ru.mts.homework9.domain.abstraction.Animal;
import ru.mts.homework9.service.CreateAnimalServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
    void createNegativeNumberOfAnimalTest(){
        int negativeAge = -10;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    createAnimalService.createAnimals(negativeAge);
                });

        assertEquals("Number of animals should be positive", exception.getMessage());
    }

    /**
     * Тест createMultipleAnimalsTest тестирует правильность работы
     * метода createAnimals
     */
    @Test
    void createMultipleAnimalsTest() {
        int n = 10;
        Map<String, List<Animal>> animals = createAnimalService.createAnimals(n);
        assertEquals(n, animals.size());
    }

    /**
     * Тест setNegativePriceOfAnimalTest тестирует работу метода
     * setPrice при передаче ему отрицательного значения
     */
    @Test
    void setNegativePriceOfAnimalTest(){
        BigDecimal negativePrice = BigDecimal.valueOf(-10);
        Animal animal = new Cat();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    animal.setCost(negativePrice);
                });

        assertEquals("Price of animal should be positive", exception.getMessage());
    }
}

