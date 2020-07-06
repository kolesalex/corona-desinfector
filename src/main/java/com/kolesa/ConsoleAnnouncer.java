package com.kolesa;

import com.kolesa.annotation.InjectByType;

public class ConsoleAnnouncer implements Announcer {

    @InjectByType
    private Recommendator recommendator;

    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
