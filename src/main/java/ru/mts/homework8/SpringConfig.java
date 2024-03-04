package ru.mts.homework8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.mts.homework8.repository.AnimalsRepository;
import ru.mts.homework8.repository.AnimalsRepositoryImpl;
import ru.mts.homework8.service.CreateAnimalService;

@Configuration
@ComponentScan("ru.mts")
public class SpringConfig {

    @Bean
    public AnimalsRepository animalsRepository(CreateAnimalService createAnimalService) {
        return new AnimalsRepositoryImpl(createAnimalService);
    }
}
