package ru.mts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Counter {
    public void counter(Shop shop){
        BigDecimal withNoSale = (shop.getNumberOfGoods().multiply(shop.getPrice()));
        System.out.println(withNoSale.setScale(2, RoundingMode.HALF_UP));
        BigDecimal withSale = (shop.getNumberOfGoods().multiply(shop.getPrice().multiply(BigDecimal.valueOf(1).subtract(shop.getSale().divide(BigDecimal.valueOf(100))))));
        System.out.println(withSale.setScale(2, RoundingMode.HALF_UP));
    }
}
