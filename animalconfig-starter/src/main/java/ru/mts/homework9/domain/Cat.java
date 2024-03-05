package ru.mts.homework9.domain;

import ru.mts.homework9.domain.abstraction.Pet;

public class Cat extends Pet  {

    @Override
    public void whatLikes() {
        System.out.println(name + " like to sleep");
    }

    public void plays() {
        System.out.println(name + " plays with a ball");
    }

    @Override
    public void sound() {
        System.out.println("meow");
    }
}
