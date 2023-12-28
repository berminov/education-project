package ru.mts.homework4.service;

import ru.mts.homework4.domain.abstraction.Animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchServiceImpl implements SearchService {
    @Override
    public List<String> findLeapYearNames(List<Animal> animal) {
        List<String> leapYearNames = new ArrayList<>();
        for (int i = 0; i < animal.size(); i++) {
            int birthYear = animal.get(i).getBirthDate().getYear();
            if (birthYear % 400 == 0) {
                leapYearNames.add(animal.get(i).getName());
            } else if (birthYear % 100 == 0) {
                break;
            } else if (birthYear % 4 == 0) {
                leapYearNames.add(animal.get(i).getName());
            }
        }
        if (leapYearNames.isEmpty()) {
            System.out.println("No animals with leap birth year");
        }
        return leapYearNames;
    }
    @Override
    public boolean checkLeapYears(List<Animal> animal) {
        for (int i = 0; i < animal.size(); i++) {
            int birthYear = animal.get(i).getBirthDate().getYear();
            if (birthYear % 400 == 0) {
                return true;
            } else if (birthYear % 100 == 0) {
                break;
            } else if (birthYear % 4 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Animal> findOlderAnimals(List<Animal> animal, int n) {
        List<Animal> olderAnimals = new ArrayList<>();
        for (int i = 0; i < animal.size(); i++) {
            LocalDate dateNow = LocalDate.now();
            LocalDate dateThen = dateNow.minusYears(n);
            if (animal.get(i).getBirthDate().toEpochDay() < dateThen.toEpochDay()) {
                olderAnimals.add(animal.get(i));
            }
        }
        return olderAnimals;
    }
    @Override
    public boolean checkOlderAnimals(List<Animal> animal, int n) {
        List<Animal> olderAnimals = new ArrayList<>();
        for (int i = 0; i < animal.size(); i++) {
            LocalDate dateNow = LocalDate.now();
            LocalDate dateThen = dateNow.minusYears(n);
            if (animal.get(i).getBirthDate().toEpochDay() < dateThen.toEpochDay()) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void findDuplicates(List<Animal> animal) {
        Set<Animal> uniqueAnimals = new HashSet<>();
        boolean check = false;
        for (int i = 0; i < animal.size(); i++) {
            if (!uniqueAnimals.add(animal.get(i))) {
                System.out.println(animal.get(i));
                check = true;
            }
        }
        if (!check) {
            System.out.println("No duplicates");
        }
    }
    @Override
    public boolean checkDuplicates(List<Animal> animal){
        Set<Animal> uniqueAnimals = new HashSet<>();
        for (int i = 0; i < animal.size(); i++) {
            if (!uniqueAnimals.add(animal.get(i))) {
                return true;
            }
        }
        return false;
    }
}
