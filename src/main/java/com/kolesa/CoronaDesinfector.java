package com.kolesa;

import com.kolesa.annotation.InjectByType;
import com.kolesa.policeman.Policeman;

@Deprecated
public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start(Room room){
        announcer.announce("Starting desinfection, get out!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Get back!");
    }

    public void desinfect(Room room){
        System.out.println("Desinfection is going on!!!");
    }
}
