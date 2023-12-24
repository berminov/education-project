package ru.mts.homework3.domain;

import ru.mts.homework3.domain.abstraction.Predator;

public class Bear extends Predator {

    public void hibernate() {
        System.out.println(name + " hibernates in winter");
    }

    @Override
    public void hunt() {
        System.out.println(name + " hunts alone");
    }

}
