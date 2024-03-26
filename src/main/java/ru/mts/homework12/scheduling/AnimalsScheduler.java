package ru.mts.homework12.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.homework12.exceptions.AgeException;
import ru.mts.homework12.exceptions.AnimalNullException;
import ru.mts.homework12.exceptions.AnimalsArraySizeException;
import ru.mts.homework12.repository.AnimalsRepository;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component(AnimalsSchedulerMBean.NAME)
public class AnimalsScheduler implements AnimalsSchedulerMBean {

    private static final Logger log = LoggerFactory.getLogger(AnimalsScheduler.class);

    private final AnimalsRepository animalsRepository;

    private final ScheduledExecutorService scheduledThreads = Executors.newScheduledThreadPool(2);

    @Autowired
    public AnimalsScheduler(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @PostConstruct
    public void init() {

//        scheduledThreads.scheduleAtFixedRate(() -> {
//            Thread.currentThread().setName("printDuplicateThread");
//
//            if (animalsRepository.isContainsDuplicates()) {
//
//                log.info("Thread: " + Thread.currentThread().getName() + " duplicates:");
//                animalsRepository.printDuplicates();
//                System.out.println("HEELLLLOOOO");
//
//            } else {
//                log.info("Thread: " + Thread.currentThread().getName() + " no duplicates");
//            }
//
//        }, 0, 10, TimeUnit.SECONDS);

        scheduledThreads.scheduleAtFixedRate(() -> {
            Thread.currentThread().setName("findAverageAgeThread");
            log.info("Thread: " + Thread.currentThread().getName() + " " + animalsRepository.findAverageAge());
        }, 0, 20, TimeUnit.SECONDS);

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

        System.out.println("Old and expensive animals " + animalsRepository.findOldAndExpensive());

        try {
            System.out.println("The three cheapest animals " + animalsRepository.findMinConstAnimals());

        } catch (AnimalsArraySizeException e) {
            System.out.println(e.getMessage());
        }

        return "Execution successfully finished!";
    }

}