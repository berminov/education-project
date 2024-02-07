package ru.mts.homework4.domain.abstraction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.homework4.domain.Cat;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatTest {

    @Test
    @DisplayName("Тест: equals for Cat")
    void testEqualsCat(){
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();

        cat1.setBirthDate(LocalDate.of(2024,01,01));
        cat1.setName("Jimmy");
        cat1.setCost(BigDecimal.valueOf(1000));
        cat1.setCharacter("Friendly");
        cat1.setBreed("Polar");

        cat2.setBirthDate(LocalDate.of(2024,01,01));
        cat2.setName("Jimmy");
        cat2.setCost(BigDecimal.valueOf(1000));
        cat2.setCharacter("Friendly");
        cat2.setBreed("Polar");

        cat3.setBirthDate(LocalDate.of(1992,11,11));
        cat3.setName("Dmitry");
        cat3.setCost(BigDecimal.valueOf(777));
        cat3.setCharacter("Aggressive");
        cat3.setBreed("Grizzly");

        assertTrue(cat1.equals(cat1));
        assertTrue(cat1.equals(cat2));
        assertFalse(cat1.equals(cat3));
    }
}
