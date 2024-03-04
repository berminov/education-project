package ru.mts.homework8.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.homework8.service.CreateAnimalService;
import ru.mts.homework8.service.CreateAnimalServiceImpl;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(AnimalProperties.class)
public class AnimalStarterConfig {
    @Bean
    @Scope("prototype")
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl();
    }
}
