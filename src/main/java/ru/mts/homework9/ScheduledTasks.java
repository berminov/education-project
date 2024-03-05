package ru.mts.homework9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.homework9.domain.abstraction.Animal;
import ru.mts.homework9.repository.AnimalsRepository;

import java.time.LocalDate;
import java.util.Map;

@Component
public class ScheduledTasks {

    private AnimalsRepository animalsRepository;

    @Autowired
    public void setAnimalsRepository(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @Scheduled(fixedRate = 60000)
    public void animalTasks() {

        Map<String, LocalDate> leapYearNames = animalsRepository.findLeapYearNames();
        if (leapYearNames.isEmpty()) {
            System.out.println("No animals with leap years' birthdays");
        } else {
            System.out.println("Names of animals with leap years' birthdays");
            System.out.println(leapYearNames);
        }

        int age = 5;
        Map<Animal, Integer> olderAnimals = animalsRepository.findOlderAnimals(age);
        System.out.println(olderAnimals);

        if (animalsRepository.isContainsDuplicates()) {
            System.out.println("Duplicates");
            animalsRepository.printDuplicates();
        } else {
            System.out.println("No duplicates");
        }
    }
}