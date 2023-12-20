package ru.mts.homework3;

import java.math.BigDecimal;

public class Bear extends Predator {
    public void hibernate() {
        System.out.println(name + " hibernates in winter");
    }
    public void hunt(){
        System.out.println(name + " hunts alone");
    }
    @Override
    public String toString() {
        return "Bear{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
