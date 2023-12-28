package ru.mts.homework4;

import ru.mts.homework4.domain.abstraction.Animal;
import ru.mts.homework4.service.CreateAnimalService;
import ru.mts.homework4.service.CreateAnimalServiceImpl;
import ru.mts.homework4.service.SearchService;
import ru.mts.homework4.service.SearchServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CreateAnimalService interfacee = new CreateAnimalServiceImpl();
        List<Animal> mainList = interfacee.createTenAnimals();
        SearchService search = new SearchServiceImpl();

        if (search.checkLeapYears(mainList)) {
            System.out.println("Names of animals with leap years' birthdays");
            System.out.println(search.findLeapYearNames(mainList));
        } else
            System.out.println("No animals with leap years' birthdays");

        int age = 10;
        if (search.checkOlderAnimals(mainList, age)) {
            System.out.println("Animals older than " + age);
            System.out.println(search.findOlderAnimals(mainList, age));
        } else
            System.out.println("No animals older than " + age);

        if (search.checkDuplicates(mainList)) {
            System.out.println("Duplicates");
            search.findDuplicates(mainList);
        } else
            System.out.println("No duplicates");
    }
}
