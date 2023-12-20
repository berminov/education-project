package ru.mts.homework3;

public interface CreateAnimalService {

    /**
     * Метод createTenAnimal создаёт 10 животных, используя цикл while
     */
    public default void createTenAnimals(){
        int i = 0;
        while (i<10){
            System.out.println(i + 1 + " animal:");
            OneRandomAnimal oneRandomAnimal = new OneRandomAnimal();
            oneRandomAnimal.creation();
            i++;
            System.out.println();
        }
    }
}
