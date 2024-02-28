package ru.mts.homework6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.homework6.domain.abstraction.Animal;
import ru.mts.homework6.repository.AnimalsRepository;

@Component
public class ScheduledTasks {

    private AnimalsRepository animalsRepository;

    @Autowired
    public void setAnimalsRepository(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @Scheduled(fixedRate = 60000)
    public void animalTasks() {
        List<String> leapYearNames = animalsRepository.findLeapYearNames();
        if (leapYearNames.isEmpty()) {
            System.out.println("No animals with leap years' birthdays");
        } else {
            System.out.println("Names of animals with leap years' birthdays");
            System.out.println(leapYearNames);
        }

        int age = 5;
        List<Animal> olderAnimals = animalsRepository.findOlderAnimals(age);
        if (olderAnimals.isEmpty()) {
            System.out.println("No animals older than " + age);

        } else {
            System.out.println("Animals older than " + age);
            System.out.println(olderAnimals);
        }

        if (animalsRepository.isContainsDuplicates()) {
            System.out.println("Duplicates");
            animalsRepository.printDuplicates();
        } else {
            System.out.println("No duplicates");
        }
    }
}