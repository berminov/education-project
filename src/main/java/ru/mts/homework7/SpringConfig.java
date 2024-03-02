package ru.mts.homework7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.mts.homework7.repository.AnimalsRepository;
import ru.mts.homework7.repository.AnimalsRepositoryImpl;
import ru.mts.homework7.service.CreateAnimalService;

@Configuration
@ComponentScan("ru.mts")
public class SpringConfig {

    @Bean
    public AnimalsRepository animalsRepository(CreateAnimalService createAnimalService) {
        return new AnimalsRepositoryImpl(createAnimalService);
    }
}
