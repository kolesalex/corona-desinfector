package com.kolesa;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.kolesa.annotation.Singleton;
import com.kolesa.config.Config;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

public class ApplicationContext {

    @Setter
    private ObjectFactory objectFactory;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();
    @Getter
    private Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    @SneakyThrows
    public <T> T getObject(Class<T> type){
        if (cache.containsKey(type)){
            return (T) cache.get(type);
        }
        Class<? extends T> implClass = type;

        if (type.isInterface()){
            implClass = config.getImplClass(type);
        }

        T t = objectFactory.createObject(implClass);

        if (implClass.isAnnotationPresent(Singleton.class)){
            cache.put(type, t);
        }
        return t;
    }
}
