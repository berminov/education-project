package ru.mts.homework12.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.mts.homework12.service.CreateAnimalService;

import java.util.List;

@Component
public class CreateAnimalServiceBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CreateAnimalService) {
            ((CreateAnimalService) bean).setAnimalType(chooseType());
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    private String chooseType() {
        var types = List.of("Bear", "Cat", "Parrot", "Wolf");

        return types.get((int) (Math.random() * types.size()));
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

}
