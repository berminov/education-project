package ru.mts.homework11.repository;

import org.apache.commons.lang3.StringUtils;
import ru.mts.homework11.domain.abstraction.Animal;
import ru.mts.homework11.exceptions.AgeException;
import ru.mts.homework11.exceptions.AnimalNullException;
import ru.mts.homework11.exceptions.AnimalsArraySizeException;
import ru.mts.homework11.service.CreateAnimalService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnimalsRepositoryImpl implements AnimalsRepository {

    private final CreateAnimalService createAnimalService;
    private Map<String, List<Animal>> animals;

    public AnimalsRepositoryImpl(CreateAnimalService createAnimalService) {
        this.createAnimalService = createAnimalService;
    }

    @PostConstruct
    public void init() {
        animals = createAnimalService.createAnimals(10);
    }

    @Override
    public void setAnimals(Map<String, List<Animal>> animals) {
        this.animals = animals;
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        var animals = collectAnimals();

        return animals.stream()
                .filter(a -> isBirthDateAnimalLeapYear(a)
                        && StringUtils.isNotBlank(a.getName()))
                .collect(Collectors.toUnmodifiableMap(
                        a -> a.getClass().getSimpleName() + " " + a.getName(),
                        Animal::getBirthDate)
                );
    }

    @Override
    public boolean isBirthDateAnimalLeapYear(Animal animal) {
        if (Objects.isNull(animal)) {
            throw new AnimalNullException("Animal doesn't exist");
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
            throw new AgeException("Age can't be negative");
        }

        var animals = collectAnimals();
        var olderAnimals = animals.stream()
                .filter(a -> getAgeOfAnimal(a) > n && isAnimalAndBirthDateNonNull(a))
                .collect(Collectors.toUnmodifiableMap(
                        Function.identity(),
                        AnimalsRepositoryImpl::getAgeOfAnimal)
                );

        if (olderAnimals.isEmpty()) {
            System.out.println("There are no animals older than the specified age, the oldest one is ");


            // try 2 ?)
            animals = collectAnimals();
            olderAnimals = animals.stream()
                    .min(Comparator.comparing(Animal::getBirthDate))
                    .map(a -> Collections.singletonMap(a, getAgeOfAnimal(a)))
                    .orElse(Collections.emptyMap());

        } else {
            System.out.println("Animals that are older than " + n);
        }

        return olderAnimals;
    }

    public static int getAgeOfAnimal(Animal animal) {

        if (Objects.isNull(animal)) {
            throw new AnimalNullException("Animal doesn't exist");
        }

        return Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
    }

    @Override
    public boolean isContainsOlderAnimals(final int n) {
        if (n < 0) {
            throw new AgeException("Age can't be negative");
        }

        var animals = collectAnimals();

        return animals.stream()
                .filter(a -> getAgeOfAnimal(a) > n && isAnimalAndBirthDateNonNull(a))
                .collect(Collectors.toUnmodifiableMap(
                        Function.identity(),
                        AnimalsRepositoryImpl::getAgeOfAnimal))
                .isEmpty();
    }

    @Override
    public void printDuplicates() {
        System.out.println(findDuplicates());
    }

    @Override
    public Map<String, List<Animal>> findDuplicates() {
        Set<Animal> uniqueAnimals = new HashSet<>();
        List<Animal> duplicatesList = new ArrayList<>();

        for (Animal animal : collectAnimals()) {
            if (uniqueAnimals.contains(animal)) {
                duplicatesList.add(animal);
            } else {
                uniqueAnimals.add(animal);
            }
        }

        return duplicatesList.stream()
                .collect(Collectors.groupingBy(a -> a.getClass().getSimpleName()));
    }

    @Override
    public boolean isContainsDuplicates() {
        Set<Animal> uniqueAnimals = new HashSet<>();
        for (Animal animal : collectAnimals()) {
            if (uniqueAnimals.contains(animal)) {
                return true;
            } else {
                uniqueAnimals.add(animal);
            }
        }

        return false;
    }

    private boolean isAnimalAndBirthDateNonNull(Animal animal) {
        if (Objects.isNull(animal)) {
            throw new AnimalNullException("Animal doesn't exist");
        }

        return Objects.nonNull(animal.getBirthDate());
    }

    private List<Animal> collectAnimals() {
        return animals.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public double findAverageAge() {
        var animals = collectAnimals();

        return animals.stream()
                .mapToDouble(AnimalsRepositoryImpl::getAgeOfAnimal)
                .average()
                .orElse(0.0);
    }

    @Override
    public BigDecimal findAveragePrice() {
        var animals = collectAnimals();

        return animals.stream()
                .map(Animal::getCost)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(animals.size()), 2, RoundingMode.HALF_UP);
    }

    @Override
    public List<Animal> findOldAndExpensive() {
        return collectAnimals().stream()
                .filter(a -> getAgeOfAnimal(a) > 5 && a.getCost().compareTo(findAveragePrice()) > 0)
                .sorted(Comparator.comparing(Animal::getBirthDate))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<String> findMinConstAnimals() throws AnimalsArraySizeException {
        if (collectAnimals().size() < 3) {
            throw new AnimalsArraySizeException("The size of animalsList is less than 3");
        }

        return collectAnimals().stream()
                .sorted(Comparator.comparing(Animal::getCost))
                .limit(3)
                .map(Animal::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toUnmodifiableList());
    }

}