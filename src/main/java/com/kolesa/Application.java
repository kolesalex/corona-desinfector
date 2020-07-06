package com.kolesa;

import java.util.Map;

import com.kolesa.config.JavaConfig;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifc2ImplClass){
        JavaConfig config = new JavaConfig(packageToScan, ifc2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        //TODO limit all singletones which are not lazy
        context.setObjectFactory(objectFactory);
        return context;
    }
}
