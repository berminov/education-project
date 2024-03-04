package ru.mts.homework8.startertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.homework8.domain.Cat;
import ru.mts.homework8.domain.abstraction.Animal;
import ru.mts.homework8.service.CreateAnimalServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = TestConfig.class)
@ActiveProfiles("test")
public class CreateAnimalServiceTest {

    @Autowired
    private CreateAnimalServiceImpl createAnimalService;

    @Test
    void CreateNegativeNumberOfAnimal(){
        int negativeAge = -10;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    createAnimalService.createAnimals(negativeAge);
                });

        assertEquals("Number of animals should be positive", exception.getMessage());
    }

    @Test
    void CreateMultipleAnimals() {
        int n = 10;
        List<Animal> animals = createAnimalService.createAnimals(n);
        assertEquals(n, animals.size());
    }

    @Test
    void setNegativePriceOfAnimal(){
        BigDecimal negativePrice = BigDecimal.valueOf(-10);
        Animal animal = new Cat();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    animal.setCost(negativePrice);
                });

        assertEquals("Number of animals should be positive", exception.getMessage());
    }
}

