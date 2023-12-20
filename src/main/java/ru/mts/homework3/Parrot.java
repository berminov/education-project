package ru.mts.homework3;

public class Parrot extends Pet {
    @Override
    public String toString() {
        return "Parrot{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
    public void whatLikes(){
        System.out.println(name + " likes to sing");
    }
}
