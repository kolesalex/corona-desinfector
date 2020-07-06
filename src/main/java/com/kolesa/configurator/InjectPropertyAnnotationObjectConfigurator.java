package com.kolesa.configurator;

import static java.util.stream.Collectors.toMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;

import com.kolesa.ApplicationContext;
import com.kolesa.annotation.InjectProperty;

import lombok.SneakyThrows;

public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {

    private final Map<String, String> propertiesMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfigurator() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        propertiesMap = new BufferedReader(new FileReader(path))
                .lines()
                .map(line -> line.split("="))
                .collect(toMap(arr -> arr[0], arr -> arr[1]));
    }

    @Override
    @SneakyThrows
    public void configure(Object object, ApplicationContext context) {
        Class<?> aClass = object.getClass();
        for (Field field : aClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);

            if (annotation != null) {
                String value = annotation.value().isEmpty()
                        ? propertiesMap.get(field.getName())
                        : propertiesMap.get(annotation.value());
                field.setAccessible(true);
                field.set(object, value);
            }
        }
    }
}
