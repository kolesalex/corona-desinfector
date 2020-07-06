package com.kolesa.configurator;

public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object toConfigure, Class implClass);
}
