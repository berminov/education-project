package ru.mts.homework9.repository;

import org.apache.commons.lang3.StringUtils;
import ru.mts.homework9.domain.abstraction.Animal;
import ru.mts.homework9.service.CreateAnimalService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
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

    public void setAnimals(Map<String, List<Animal>> animals) {
        this.animals = animals;
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {

        Map<String, LocalDate> mapResult = new HashMap<>();
        String name;

        animalsList().stream()
                .filter(animal -> isBirthDateAnimalLeapYear(animal)
                        && StringUtils.isNotBlank(animal.getName()))
                .forEach(animal -> mapResult.put(animal.getClass().getSimpleName() + " "
                        + animal.getName(), animal.getBirthDate()));
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

        animalsList().stream()
                .filter(animal -> getAgeOfAnimal(animal) > n && isAnimalAndBirthDateNonNull(animal))
                .forEach(animal -> olderAnimals.put(animal, getAgeOfAnimal(animal)));

        if (olderAnimals.isEmpty()) {
            System.out.println("There are no animals older than the specified age, the oldest one is ");

            Optional<Animal> oldestAnimal = animalsList().stream()
                    .min(Comparator.comparing(Animal::getBirthDate));
            oldestAnimal.ifPresent(animal -> olderAnimals.put(animal, getAgeOfAnimal(animal)));
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

        animalsList().stream()
                .filter(animal -> getAgeOfAnimal(animal) > n && isAnimalAndBirthDateNonNull(animal))
                .forEach(animal -> olderAnimals.put(animal, getAgeOfAnimal(animal)));
        return olderAnimals.isEmpty();
    }

    @Override
    public void printDuplicates() {
        System.out.println(findDuplicates());
    }

    @Override
    public Map<String, List<Animal>> findDuplicates() {

        Set<Animal> uniqueAnimals = new HashSet<>();
        List<Animal> duplicatesList = new ArrayList<>();

        for (Animal animal : animalsList()) {
            if (uniqueAnimals.contains(animal)) {
                duplicatesList.add(animal);
            } else {
                uniqueAnimals.add(animal);
            }
        }

        Map<String, List<Animal>> duplicates = duplicatesList.stream()
                .collect(Collectors.groupingBy(animal -> animal.getClass().getSimpleName()));

        return new HashMap<>(duplicates);
    }

    @Override
    public boolean isContainsDuplicates() {
        Set<Animal> uniqueAnimals = new HashSet<>();
        for (Animal animal : animalsList()) {
            if (uniqueAnimals.contains(animal)) {
                return true;
            } else {
                uniqueAnimals.add(animal);
            }
        }
        return false;
    }

    private boolean isAnimalAndBirthDateNonNull(Animal animal) {
        return Objects.nonNull(animal)
                && Objects.nonNull(animal.getBirthDate());
    }

    private List<Animal> animalsList() {
        List<List<Animal>> listOfLists = new ArrayList<>(animals.values());
        return listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public double findAverageAge() {
        return animalsList().stream()
                .mapToDouble(AnimalsRepositoryImpl::getAgeOfAnimal)
                .average()
                .orElse(0.0);
    }

    @Override
    public BigDecimal findAveragePrice() {
        return animalsList().stream()
                .map(Animal::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(animalsList().size()), 2, RoundingMode.HALF_UP);
    }

    @Override
    public List<Animal> findOldAndExpensive() {
        return animalsList().stream()
                .filter(animal -> getAgeOfAnimal(animal) > 5 && animal.getCost().compareTo(findAveragePrice()) > 0)
                .sorted(Comparator.comparing(Animal::getBirthDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findMinConstAnimals() {
        return animalsList().stream()
                .sorted(Comparator.comparing(Animal::getCost))
                .limit(3)
                .map(Animal::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}