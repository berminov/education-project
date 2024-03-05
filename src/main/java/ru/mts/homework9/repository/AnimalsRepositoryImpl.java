package ru.mts.homework9.repository;

import org.apache.commons.lang3.StringUtils;
import ru.mts.homework9.domain.Cat;
import ru.mts.homework9.domain.abstraction.Animal;
import ru.mts.homework9.service.CreateAnimalService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class AnimalsRepositoryImpl implements AnimalsRepository {

    private final CreateAnimalService createAnimalService;

    public AnimalsRepositoryImpl(CreateAnimalService createAnimalService) {
        this.createAnimalService = createAnimalService;
    }

    private Map<String, List<Animal>> animals;

    public void setAnimals(Map<String, List<Animal>> animals) {
        this.animals = animals;
    }

    @PostConstruct
    public void init() {
        animals = createAnimalService.createAnimals(10);
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {

        Map<String, LocalDate> mapResult = new HashMap<>();
        String name;

        for (Map.Entry<String, List<Animal>> entry : animals.entrySet()) {
            for (Animal animal : entry.getValue()) {
                if (isBirthDateAnimalLeapYear(animal)) {
                    name = animal.getName();
                    if (StringUtils.isNotBlank(name)) {
                        mapResult.put(animal.getClass().getSimpleName() + " "
                                + animal.getName(), animal.getBirthDate());
                    }
                }
            }
        }
        return mapResult;
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
    public Map<Animal, Integer> findOlderAnimals(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Age can't be negative");
        }

        Map<Animal, Integer> olderAnimals = new HashMap<>();
        Animal oldestAnimal = new Cat();

        oldestAnimal.setBirthDate(LocalDate.now());

        for (Map.Entry<String, List<Animal>> entry : animals.entrySet()) {
            for (Animal animal : entry.getValue()) {
                if (isAnimalAndBirthDateNonNull(animal) && n < getAgeOfAnimal(animal)) {
                    olderAnimals.put(animal, getAgeOfAnimal(animal));
                }
                if (getAgeOfAnimal(animal) > getAgeOfAnimal(oldestAnimal)) {
                    oldestAnimal = animal;
                }
            }
        }
        if (olderAnimals.isEmpty()) {
            System.out.println("There are no animals older than the specified age");
            olderAnimals.put(oldestAnimal, getAgeOfAnimal(oldestAnimal));
        } else {
            System.out.println("Animals that are older than " + n);
        }
        return olderAnimals;
    }

    public static int getAgeOfAnimal(Animal animal) {
        return Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
    }

    @Override
    public boolean isContainsOlderAnimals(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Age can't be negative");
        }

        Map<Animal, Integer> olderAnimals = new HashMap<>();
        var dateNow = LocalDate.now();

        for (Map.Entry<String, List<Animal>> entry : animals.entrySet()) {
            for (Animal animal : entry.getValue()) {
                int age = Period.between(animal.getBirthDate(), dateNow).getYears();
                if (isAnimalAndBirthDateNonNull(animal) && n < age) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void printDuplicates() {
        System.out.println(findDuplicates());
    }

    @Override
    public Map<String, Integer> findDuplicates() {

        Map<String, Integer> duplicatesMap = new HashMap<>();

        Set<Animal> uniqueAnimals = new HashSet<>();
        Set<Animal> duplicatesList = new LinkedHashSet<>();

        for (Map.Entry<String, List<Animal>> entry : animals.entrySet()) {
            for (Animal animal : entry.getValue()) {
                if (uniqueAnimals.contains(animal)) {
                    duplicatesList.add(animal);
                } else {
                    uniqueAnimals.add(animal);
                }
            }
        }

        for (Animal animal : duplicatesList) {
            String animalType = animal.getClass().getSimpleName();
            if (duplicatesMap.containsKey(animalType)) {
                duplicatesMap.put(animalType, duplicatesMap.get(animalType) + 1);
            } else {
                duplicatesMap.put(animalType, 1);
            }
        }

        return new HashMap<>(duplicatesMap);
    }

    @Override
    public boolean isContainsDuplicates() {
        Set<Animal> uniqueAnimals = new HashSet<>();

        for (Map.Entry<String, List<Animal>> entry : animals.entrySet()) {
            for (Animal animal : entry.getValue()) {
                if (uniqueAnimals.contains(animal)) {
                    return true;
                } else {
                    uniqueAnimals.add(animal);
                }
            }
        }
        return false;
    }

    private boolean isAnimalAndBirthDateNonNull(Animal animal) {
        return Objects.nonNull(animal)
                && Objects.nonNull(animal.getBirthDate());
    }
}
