package com.conversor.conversor.Util;

import java.util.Arrays;
import java.util.List;

public enum Divisas {
    EUR("Euro"),
    MXN("Mexican Peso"),
    SVC("Salvadoran Colon"),
    USD("United States Dollar"),
    BRL("Brazilian Real"),
    CAD("Canadian Dollar"),
    COP("Colombian Peso");

    private final String name;

    Divisas(String stringValue){
        this.name=stringValue;
    }

    public String getDivisa(){
        return name;
    }

    public static List<Divisas> getAllDivisas(){
        return Arrays.asList(Divisas.values());
    }

    @Override
    public String toString() {
        return name;
    }
}
