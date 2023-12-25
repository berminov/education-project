package ru.mts.homework3;

import ru.mts.homework3.factory.AnimalTypes;
import ru.mts.homework3.service.CreateAnimalService;
import ru.mts.homework3.service.CreateAnimalServiceImpl;

public class Main {

    public static void main(String[] args) {
        new CreateAnimalService() {
        }.createTenAnimals();

        CreateAnimalService interfacee = new CreateAnimalServiceImpl();
        interfacee.createTenAnimals();

        if (interfacee instanceof CreateAnimalServiceImpl) {
            CreateAnimalServiceImpl impl = ((CreateAnimalServiceImpl) interfacee);
            impl.createNAnimal(20);
            impl.createNAnimal();
        }
        for (int i = 0; i<10; i++){
            System.out.println(AnimalTypes.getRandomType());
        }

    }

}
