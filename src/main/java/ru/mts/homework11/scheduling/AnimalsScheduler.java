package ru.mts.homework11.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.homework11.exceptions.AgeException;
import ru.mts.homework11.exceptions.AnimalNullException;
import ru.mts.homework11.exceptions.AnimalsArraySizeException;
import ru.mts.homework11.repository.AnimalsRepository;

@Component(AnimalsSchedulerMBean.NAME)
public class AnimalsScheduler implements AnimalsSchedulerMBean {

    private static final Logger log = LoggerFactory.getLogger(AnimalsScheduler.class);

    private final AnimalsRepository animalsRepository;

    @Autowired
    public AnimalsScheduler(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @Scheduled(fixedRate = 60_000)
    public String executeTask() {
        try {
            var leapYearNames = animalsRepository.findLeapYearNames();
            if (leapYearNames.isEmpty()) {
                log.info("No animals with leap years' birthdays");
            } else {
                System.out.println("Names of animals with leap years' birthdays");
                System.out.println(leapYearNames);
            }

        } catch (AnimalNullException e) {
            System.out.println(e.getMessage());
        }

        try {
            int age = 10;
            var olderAnimals = animalsRepository.findOlderAnimals(age);
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

        return "Execution successfully finished!";
    }

}