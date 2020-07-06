package com.kolesa.configurator;

import java.lang.reflect.Field;

import com.kolesa.ApplicationContext;
import com.kolesa.annotation.InjectByType;

import lombok.SneakyThrows;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator{

    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(InjectByType.class)){
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(t, object);
            }
        }
    }
}
