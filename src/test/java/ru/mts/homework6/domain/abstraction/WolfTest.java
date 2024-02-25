package ru.mts.homework6.domain.abstraction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.homework6.domain.Wolf;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WolfTest {

    @Test
    @DisplayName("Тест: equals for Wolf")
    void testEqualsWolf() {
        Wolf wolf1 = new Wolf();
        Wolf wolf2 = new Wolf();
        Wolf wolf3 = new Wolf();

        wolf1.setBirthDate(LocalDate.of(2024, 01, 01));
        wolf1.setName("Jimmy");
        wolf1.setCost(BigDecimal.valueOf(1000));
        wolf1.setCharacter("Friendly");
        wolf1.setBreed("Polar");

        wolf2.setBirthDate(LocalDate.of(2024, 01, 01));
        wolf2.setName("Jimmy");
        wolf2.setCost(BigDecimal.valueOf(1000));
        wolf2.setCharacter("Friendly");
        wolf2.setBreed("Polar");

        wolf3.setBirthDate(LocalDate.of(1992, 11, 11));
        wolf3.setName("Dmitry");
        wolf3.setCost(BigDecimal.valueOf(777));
        wolf3.setCharacter("Aggressive");
        wolf3.setBreed("Grizzly");

        assertTrue(wolf1.equals(wolf1));
        assertTrue(wolf1.equals(wolf2));
        assertFalse(wolf1.equals(wolf3));
    }
}
