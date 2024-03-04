package ru.mts.homework7.domain.abstraction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class AbstractAnimal implements Animal {

    protected String breed;        // порода
    protected String name;         // имя
    protected BigDecimal cost;     // цена в магазине (до 2х знаков)
    protected String character;    // характер
    protected LocalDate birthDate; // дата рождения

    public AbstractAnimal() {
    }

    public AbstractAnimal(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "breed='" + getBreed() + '\'' +
                ", name='" + getName() + '\'' +
                ", cost=" + (Objects.isNull(getCost()) ? "null" : getCost().toPlainString()) +
                ", character='" + getCharacter() + '\'' +
                ", birthDate=" + (Objects.isNull(getBirthDate()) ? "null" : String.format("%1$td-%1$tm-%1$tY", getBirthDate())) +
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

    @Override
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

    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractAnimal that = (AbstractAnimal) o;

        return Objects.equals(breed, that.breed)
                && Objects.equals(name, that.name)
                && Objects.equals(character, that.character)
                && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, character, birthDate);
    }

}
