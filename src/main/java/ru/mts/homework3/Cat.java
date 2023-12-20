package ru.mts.homework3;

public class Cat extends Pet {
    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
    public void whatLikes(){
        System.out.println(name + " like to sleep");
    }
    public void plays(){
        System.out.println(name + " plays with a ball");
    }
}
