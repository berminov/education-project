package ru.mts.homework3.domain;

import ru.mts.homework3.domain.abstraction.Pet;

public class Parrot extends Pet {

    @Override
    public void whatLikes() {
        System.out.println(getName() + " likes to sing");
    }

}
