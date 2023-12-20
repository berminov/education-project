package ru.mts.homework3;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    /**
     * Методо createTenAnimals переопределяет default метод интерфейса
     * CreateAnimalService
     */
    @Override
    public void createTenAnimals() {
        int i = 0;
        do {
            System.out.println(i + 1 + " animal:");
            OneRandomAnimal oneRandomAnimal = new OneRandomAnimal();
            oneRandomAnimal.creation();
            i++;
            System.out.println();
        } while (i < 10);
    }

    /**
     * Метод createNAnimal создаёт n уникальных животных
     */
    public void createNAnimal(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " animal:");
            OneRandomAnimal oneRandomAnimal = new OneRandomAnimal();
            oneRandomAnimal.creation();
            System.out.println();
        }
    }

    /**
     * В случае, если параметр n, не был передан метод createNAnimal создает
     * одно уникальное животное
     */
    public void createNAnimal() {
        System.out.println("The only animal:");
        OneRandomAnimal oneRandomAnimal = new OneRandomAnimal();
        oneRandomAnimal.creation();
        System.out.println();
    }
}
