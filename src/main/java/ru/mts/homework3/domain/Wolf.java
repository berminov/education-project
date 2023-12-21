package ru.mts.homework3.domain;

import ru.mts.homework3.domain.abstraction.Predator;

public class Wolf extends Predator {

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts in a pack");
    }

    public void howl() {
        System.out.println("Wolf " + getName() + " howls at the moon");
    }

}
