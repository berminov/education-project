package ru.mts.homework6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.homework6.repository.AnimalsRepository;
import ru.mts.homework6.repository.AnimalsRepositoryImpl;
import ru.mts.homework6.service.CreateAnimalService;
import ru.mts.homework6.service.CreateAnimalServiceImpl;

@Configuration
@ComponentScan("ru.mts")
public class SpringConfig {

    @Bean
    public AnimalsRepository animalsRepository(CreateAnimalService createAnimalService) {
        return new AnimalsRepositoryImpl(createAnimalService);
    }


}
