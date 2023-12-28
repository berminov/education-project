package ru.mts.homework4;

import ru.mts.homework4.domain.abstraction.Animal;
import ru.mts.homework4.factory.RandomAnimalFactory;
import ru.mts.homework4.factory.ReflectionAnimalAbstractFactory;
import ru.mts.homework4.service.CreateAnimalService;
import ru.mts.homework4.service.CreateAnimalServiceImpl;
import ru.mts.homework4.service.SearchService;
import ru.mts.homework4.service.SearchServiceImpl;

import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        CreateAnimalService createAnimalService = createAnimalService();

        List<Animal> mainList = Objects.isNull(createAnimalService) ?
                new CreateAnimalService() {
                }.createTenAnimals()
                : createAnimalService.createTenAnimals();

        SearchService search = new SearchServiceImpl();

        List<String> leapYearNames = search.findLeapYearNames(mainList);
        if (leapYearNames.isEmpty()) {
            System.out.println("No animals with leap years' birthdays");
        } else {
            System.out.println("Names of animals with leap years' birthdays");
            System.out.println(leapYearNames);
        }

        int age = 10;
        List<Animal> olderAnimals = search.findOlderAnimals(mainList, age);
        if (olderAnimals.isEmpty()) {
            System.out.println("Animals older than " + age);
            System.out.println(olderAnimals);
        } else {
            System.out.println("No animals older than " + age);
        }

        if (search.isContainsDuplicates(mainList)) {
            System.out.println("Duplicates");
            search.findDuplicates(mainList);
        } else {
            System.out.println("No duplicates");
        }

    }

    private static CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl(new RandomAnimalFactory(new ReflectionAnimalAbstractFactory()));
    }

}
