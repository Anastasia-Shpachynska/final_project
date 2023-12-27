package com.example.final_project.config.processor.beans;

import com.example.final_project.config.processor.annotation.InjectLog;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@AllArgsConstructor
public class InjectLogAnnotationBeanPostProcessor implements BeanPostProcessor {

    private final ApplicationContext context;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(InjectLog.class)) {
                Object logger = context.getBean("loggerService");
                field.setAccessible(true);
                try {
                    field.set(bean, logger);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
