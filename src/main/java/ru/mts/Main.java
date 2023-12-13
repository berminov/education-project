package ru.mts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        Shop shop1 = new Shop(BigDecimal.valueOf(10), BigDecimal.valueOf(100), BigDecimal.valueOf(0.75));
        Shop shop2 = new Shop(BigDecimal.valueOf(10), BigDecimal.valueOf(100), BigDecimal.valueOf(42.575));
        Shop shop3 = new Shop(BigDecimal.valueOf(10), BigDecimal.valueOf(100));
        Counter countShop = new Counter();
        countShop.counter(shop1);
        countShop.counter(shop2);
        countShop.counter(shop3);
    }
}


