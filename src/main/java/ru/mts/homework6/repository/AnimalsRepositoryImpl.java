package ru.mts.homework6.repository;

import org.apache.commons.lang3.StringUtils;
import ru.mts.homework6.domain.abstraction.Animal;
import ru.mts.homework6.factory.RandomAnimalFactory;
import ru.mts.homework6.factory.ReflectionAnimalAbstractFactory;
import ru.mts.homework6.service.CreateAnimalService;
import ru.mts.homework6.service.CreateAnimalServiceImpl;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

public class AnimalsRepositoryImpl implements AnimalsRepository {

    private List<Animal> mainList;

    public void setMainList(List<Animal> mainList) {
        this.mainList = mainList;
    }

    @PostConstruct
    public void init() {
        CreateAnimalService createAnimalService = createAnimalService();
        setMainList(createAnimalService.createTenAnimals());
    }

    private static CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl(new RandomAnimalFactory(new ReflectionAnimalAbstractFactory()));
    }

    @Override
    public List<String> findLeapYearNames() {
        List<String> result = new ArrayList<>();

        String name;
        for (var value : mainList) {
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
    public List<Animal> findOlderAnimals(int n) {
        var dateNow = LocalDate.now();
        var dateThen = dateNow.minusYears(n);


        List<Animal> olderAnimals = new ArrayList<>();
        for (var value : mainList) {
            if (isAnimalAndBirthDateNonNull(value)
                    && (value.getBirthDate().toEpochDay() < dateThen.toEpochDay())) {

                olderAnimals.add(value);
            }
        }

        return olderAnimals;
    }

    @Override
    public boolean isContainsOlderAnimals(int n) {
        var now = LocalDate.now();
        var dateThen = now.minusYears(n);

        for (var value : mainList) {
            if (isAnimalAndBirthDateNonNull(value)
                    && (value.getBirthDate().toEpochDay() < dateThen.toEpochDay())) {

                return true;
            }

        }

        return false;
    }

    @Override
    public void printDuplicates() {
        System.out.println(findDuplicates());
    }

    @Override
    public List<Animal> findDuplicates() {
        Set<Animal> uniqueAnimals = new HashSet<>();
        Set<Animal> duplicates = new LinkedHashSet<>();

        for (var value : mainList) {
            if (uniqueAnimals.contains(value)) {
                duplicates.add(value);
            } else {
                uniqueAnimals.add(value);
            }
        }
        return new ArrayList<>(duplicates);
    }

    @Override
    public boolean isContainsDuplicates() {
        Set<Animal> uniqueAnimals = new HashSet<>();
        for (var value : mainList) {
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
