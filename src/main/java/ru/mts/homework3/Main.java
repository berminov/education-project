package ru.mts.homework3;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl zoo = new CreateAnimalServiceImpl();
        zoo.createTenAnimals();
        zoo.createNAnimal(20);
        zoo.createNAnimal();
    }
}
