package ru.mts.homework3;

public class Wolf extends Predator {
    @Override
    public String toString() {
        return "Wolf{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
    public void hunt(){
        System.out.println(name + " hunts in a pack");
    }
    public void howl() {
        System.out.println("Wolf " + name + " howls at the moon");
    }
}
