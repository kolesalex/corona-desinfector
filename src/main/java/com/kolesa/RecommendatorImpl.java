package com.kolesa;

import com.kolesa.annotation.InjectProperty;
import com.kolesa.annotation.Singleton;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("whisky")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("Recommendator was created!");
    }

    @Override
    public void recommend() {
        System.out.println("drink to protect from COVID-2019 " + alcohol);
    }
}
