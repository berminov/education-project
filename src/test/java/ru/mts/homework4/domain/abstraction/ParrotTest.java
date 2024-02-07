package ru.mts.homework4.domain.abstraction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.homework4.domain.Parrot;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParrotTest {


    @Test
    @DisplayName("Тест: equals for Parrot")
    void testEqualsParrot() {
        Parrot parrot1 = new Parrot();
        Parrot parrot2 = new Parrot();
        Parrot parrot3 = new Parrot();

        parrot1.setBirthDate(LocalDate.of(2024, 01, 01));
        parrot1.setName("Jimmy");
        parrot1.setCost(BigDecimal.valueOf(1000));
        parrot1.setCharacter("Friendly");
        parrot1.setBreed("Polar");

        parrot2.setBirthDate(LocalDate.of(2024, 01, 01));
        parrot2.setName("Jimmy");
        parrot2.setCost(BigDecimal.valueOf(1000));
        parrot2.setCharacter("Friendly");
        parrot2.setBreed("Polar");

        parrot3.setBirthDate(LocalDate.of(1992, 11, 11));
        parrot3.setName("Dmitry");
        parrot3.setCost(BigDecimal.valueOf(777));
        parrot3.setCharacter("Aggressive");
        parrot3.setBreed("Grizzly");

        assertTrue(parrot1.equals(parrot1));
        assertTrue(parrot1.equals(parrot2));
        assertFalse(parrot1.equals(parrot3));
    }
}
