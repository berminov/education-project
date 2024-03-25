package ru.mts.homework11.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.homework11.service.CreateAnimalService;
import ru.mts.homework11.service.CreateAnimalServiceImpl;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(AnimalProperties.class)
public class AnimalStarterConfig {

    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl();
    }

}
