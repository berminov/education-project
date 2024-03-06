package ru.mts.homework9.startertest;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.mts.homework9.factory.*;

@TestConfiguration
public class TestConfig {
    @Bean
    public OneRandomAnimal oneRandomAnimalTest() {
        return new OneRandomAnimal(bearFactoryTest(), catFactoryTest(),
                parrotFactoryTest(), wolfFactoryTest());
    }

    @Bean
    public BearFactory bearFactoryTest() {
        return new BearFactory();
    }

    @Bean
    public CatFactory catFactoryTest() {
        return new CatFactory();
    }

    @Bean
    public ParrotFactory parrotFactoryTest() {
        return new ParrotFactory();
    }

    @Bean
    public WolfFactory wolfFactoryTest() {
        return new WolfFactory();
    }
}
