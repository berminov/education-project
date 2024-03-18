package ru.mts.homework11.factory;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateProvider {

    public static LocalDate createRandomDate() {
        long minDay = LocalDate.of(2000, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current()
                .nextLong(minDay, maxDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
