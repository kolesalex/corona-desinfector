package com.kolesa;

import java.util.HashMap;
import java.util.Map;

import com.kolesa.policeman.Policeman;
import com.kolesa.policeman.PolicemanImpl;

public class Main {
    public static void main(String[] args) {
//        CoronaDesinfector coronaDesinfector = ObjectFactory.getInstance().create(CoronaDesinfector.class);
        ApplicationContext context = Application.run("com.kolesa", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        CoronaDesinfector coronaDesinfector = context.getObject(CoronaDesinfector.class);
        coronaDesinfector.start(new Room());
    }
}
