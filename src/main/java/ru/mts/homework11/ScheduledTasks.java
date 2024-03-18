package ru.mts.homework11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.homework11.domain.abstraction.Animal;
import ru.mts.homework11.exceptions.AgeException;
import ru.mts.homework11.exceptions.AnimalNullException;
import ru.mts.homework11.exceptions.AnimalsArraySizeException;
import ru.mts.homework11.repository.AnimalsRepository;

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
        try {
            Map<String, LocalDate> leapYearNames = animalsRepository.findLeapYearNames();
            if (leapYearNames.isEmpty()) {
                System.out.println("No animals with leap years' birthdays");
            } else {
                System.out.println("Names of animals with leap years' birthdays");
                System.out.println(leapYearNames);
            }
        } catch (AnimalNullException e) {
            System.out.println(e.getMessage());
        }

        try {
            int age = 10;
            Map<Animal, Integer> olderAnimals = animalsRepository.findOlderAnimals(age);
            System.out.println(olderAnimals);

            if (animalsRepository.isContainsDuplicates()) {
                System.out.println("Duplicates");
                animalsRepository.printDuplicates();
            } else {
                System.out.println("No duplicates");
            }
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Average age of all animals is " + animalsRepository.findAverageAge());
        System.out.println("Old and expensive animals " + animalsRepository.findOldAndExpensive());

        try {
            System.out.println("The three cheapest animals " + animalsRepository.findMinConstAnimals());
        } catch (AnimalsArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }
}