package com.kolesa.config;

import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import lombok.Getter;

public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    private Map<Class, Class> interface2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> interface2ImplClass) {
        this.interface2ImplClass = interface2ImplClass;
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> intrf) {
        return interface2ImplClass.computeIfAbsent(intrf, clazz -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(intrf);
            if(classes.size() != 1){
                throw new RuntimeException(intrf + " has more than one impl");
            }
            return classes.iterator().next();
        });

    }
}
