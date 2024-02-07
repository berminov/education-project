package ru.mts.homework4.domain;

import ru.mts.homework4.domain.abstraction.Predator;

import java.time.LocalDate;

public class Bear extends Predator {

    public void hibernate() {
        System.out.println(name + " hibernates in winter");
    }

    @Override
    public void hunt() {
        System.out.println(name + " hunts alone");
    }

    @Override
    public void sound() {
        System.out.println("rrrrrr");
    }

}
