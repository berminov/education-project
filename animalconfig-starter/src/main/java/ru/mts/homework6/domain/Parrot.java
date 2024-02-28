package ru.mts.homework6.domain;

import ru.mts.homework6.domain.abstraction.Pet;

public class Parrot extends Pet {

    @Override
    public void whatLikes() {
        System.out.println(getName() + " likes to sing");
    }

    @Override
    public void sound() {
        System.out.println("Hello niggas");
    }

}
