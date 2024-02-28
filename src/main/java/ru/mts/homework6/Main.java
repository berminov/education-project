package ru.mts.homework6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.mts.homework6.domain.abstraction.Animal;
import ru.mts.homework6.repository.AnimalsRepository;

import java.util.List;
@SpringBootApplication
@ComponentScan("ru.mts")
@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );
        AnimalsRepository animalsRepository = context.getBean(AnimalsRepository.class);

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
