package com.kolesa.policeman;

import com.kolesa.Recommendator;
import com.kolesa.annotation.InjectByType;

public class AngryPoliceman implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Повбиваю!");
    }
}
