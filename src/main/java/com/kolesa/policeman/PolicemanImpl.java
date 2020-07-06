package com.kolesa.policeman;


import com.kolesa.Recommendator;
import com.kolesa.annotation.InjectByType;
import com.kolesa.annotation.PostConstruct;

public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    /**
     * Second phase constructor
     */
    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Піф-паф, геть!");
    }
}
