package ru.mts.homework4.service;

import org.apache.commons.lang3.StringUtils;
import ru.mts.homework4.domain.abstraction.Animal;

import java.time.LocalDate;
import java.util.*;

public class SearchServiceImpl implements SearchService {

    @Override
    public List<String> findLeapYearNames(List<Animal> animals) {
        List<String> result = new ArrayList<>();

        String name;
        for (var value : animals) {
            if (isBirthDateAnimalLeapYear(value)) {

                name = value.getName();
                if (StringUtils.isNotBlank(name)) {
                    result.add(name);
                }

            }
        }

        if (result.isEmpty()) {
            System.out.println("No animals with leap birth year");
        }

        return result;
    }

    @Override
    public boolean isBirthDateAnimalLeapYear(Animal animal) {
        if (Objects.isNull(animal)) {
            return false;
        }

        var birthDate = animal.getBirthDate();
        if (Objects.isNull(birthDate)) {
            return false;
        }

        return birthDate.isLeapYear();
    }

    @Override
    public List<Animal> findOlderAnimals(List<Animal> animals, int n) {
        var dateNow = LocalDate.now();
        var dateThen = dateNow.minusYears(n);

        List<Animal> olderAnimals = new ArrayList<>();
        for (var value : animals) {
            if (isAnimalAndBirthDateNonNull(value)
                    && (value.getBirthDate().toEpochDay() < dateThen.toEpochDay())) {

                olderAnimals.add(value);
            }
        }

        return olderAnimals;
    }

    @Override
    public boolean isContainsOlderAnimals(List<Animal> animals, int n) {
        var now = LocalDate.now();
        var dateThen = now.minusYears(n);

        for (var value : animals) {
            if (isAnimalAndBirthDateNonNull(value)
                    && (value.getBirthDate().toEpochDay() < dateThen.toEpochDay())) {

                return true;
            }

        }

        return false;
    }

    @Override
    public void findDuplicates(List<Animal> animals) {
        Set<Animal> uniqueAnimals = new HashSet<>();
        Set<Animal> duplicates = new LinkedHashSet<>();

        for (var value : animals) {
            if (uniqueAnimals.contains(value)) {
                duplicates.add(value);
            } else {
                uniqueAnimals.add(value);
            }

        }

        System.out.println(duplicates);
    }

    @Override
    public boolean isContainsDuplicates(List<Animal> animals) {
        Set<Animal> uniqueAnimals = new HashSet<>();
        for (var value : animals) {
            //very good ;)
            if (!uniqueAnimals.add(value)) {
                return true;
            }

        }

        return false;
    }

    private boolean isAnimalAndBirthDateNonNull(Animal animal) {
        return Objects.nonNull(animal)
                && Objects.nonNull(animal.getBirthDate());
    }

}
