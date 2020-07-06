package com.kolesa.config;

import org.reflections.Reflections;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> intrf);

    Reflections getScanner();
}
