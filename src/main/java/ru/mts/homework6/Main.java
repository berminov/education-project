package ru.mts.homework6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableScheduling
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
}
