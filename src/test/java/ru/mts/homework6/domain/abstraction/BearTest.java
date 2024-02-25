package ru.mts.homework6.domain.abstraction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.homework6.domain.Bear;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    @DisplayName("Тест: equals for Bear")
    void testEqualsBear() {

        Bear bear1 = new Bear();
        Bear bear2 = new Bear();
        Bear bear3 = new Bear();

        bear1.setBirthDate(LocalDate.of(2024, 01, 01));
        bear1.setName("Jimmy");
        bear1.setCost(BigDecimal.valueOf(1000));
        bear1.setCharacter("Friendly");
        bear1.setBreed("Polar");

        bear2.setBirthDate(LocalDate.of(2024, 01, 01));
        bear2.setName("Jimmy");
        bear2.setCost(BigDecimal.valueOf(1000));
        bear2.setCharacter("Friendly");
        bear2.setBreed("Polar");

        bear3.setBirthDate(LocalDate.of(1992, 11, 11));
        bear3.setName("Dmitry");
        bear3.setCost(BigDecimal.valueOf(777));
        bear3.setCharacter("Aggressive");
        bear3.setBreed("Grizzly");

        assertTrue(bear1.equals(bear1));
        assertTrue(bear1.equals(bear2));
        assertFalse(bear1.equals(bear3));
    }
}