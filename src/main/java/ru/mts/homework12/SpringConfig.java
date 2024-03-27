package ru.mts.homework12;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.mts.homework12.repository.AnimalsRepository;
import ru.mts.homework12.repository.AnimalsRepositoryImpl;
import ru.mts.homework12.service.CreateAnimalService;

@Configuration
@ComponentScan("ru.mts")
public class SpringConfig {

    @Bean
    public AnimalsRepository animalsRepository(CreateAnimalService createAnimalService) {
        return new AnimalsRepositoryImpl(createAnimalService);
    }

}
