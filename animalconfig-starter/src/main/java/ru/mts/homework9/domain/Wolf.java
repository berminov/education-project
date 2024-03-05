package ru.mts.homework9.domain;

import ru.mts.homework9.domain.abstraction.Predator;

public class Wolf extends Predator {

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts in a pack");
    }

    public void howl() {
        System.out.println("Wolf " + getName() + " howls at the moon");
    }

    @Override
    public void sound() {
        System.out.println("Wooooooooo");
    }

}
