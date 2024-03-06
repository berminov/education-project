package ru.mts.homework10.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.mts.homework10.service.CreateAnimalService;

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
        String[] types = {"Bear", "Cat", "Parrot", "Wolf"};
        String randomType = types[(int) (Math.random() * types.length)];
        return randomType;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
