package ru.mts;

import java.math.BigDecimal;

public class Shop {
    /*
               В классе Shop есть поля, отвечающие за
               количество товаров, их цену и скидку на них, а также
               метод, выводящий общую сумму со скидкой и без
                */
    public Shop(BigDecimal numberOfGoods, BigDecimal price, BigDecimal sale) {
        this.numberOfGoods = numberOfGoods;
        this.price = price;
        this.sale = sale;
    }
    public Shop(BigDecimal numberOfGoods, BigDecimal price) {
        this.numberOfGoods = numberOfGoods;
        this.price = price;
        this.sale = BigDecimal.valueOf(0);
    }
    // numberOfGoods - количество товаров
    private BigDecimal numberOfGoods;
    // price - цена товара
    private BigDecimal price;
    // sale - скидка на товар
    private BigDecimal sale;
    public BigDecimal getNumberOfGoods() {
        return numberOfGoods;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public BigDecimal getSale() {
        return sale;
    }
    /*
    public void counter() {
        BigDecimal withNoSale = numberOfGoods.multiply(price);
        System.out.println(withNoSale.setScale(2, RoundingMode.HALF_UP));
        BigDecimal withSale = (numberOfGoods.multiply(price.multiply(BigDecimal.valueOf(1).subtract(sale.divide(BigDecimal.valueOf(100))))));
        System.out.println(withSale.setScale(2, RoundingMode.HALF_UP));
    }
    */
}
