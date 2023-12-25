package ru.mts.homework3.domain.abstraction;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class AbstractAnimal implements Animal {

    protected String breed;     // порода
    protected String name;      // имя
    protected BigDecimal cost;  // цена в магазине (до 2х знаков)
    protected String character; // характер

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "breed='" + getBreed() + '\'' +
                ", name='" + getName() + '\'' +
                ", cost=" + (Objects.isNull(getCost()) ? "null" : getCost().toPlainString()) +
                ", character='" + getCharacter() + '\'' +
                '}';
    }

    @Override
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    @Override
    public String getCharacter() {
        return character;
    }

}
