package com.conversor.conversor.Util;

/*Formulas usadas para las conversiones
Para convertir de ºC a ºF use la fórmula:   ºF = ºC x 1.8 + 32.
Para convertir de ºF a ºC use la fórmula:   ºC = (ºF-32) ÷ 1.8.
Para convertir de K a ºC use la fórmula:   ºC = K – 273.15
Para convertir de ºC a K use la fórmula: K = ºC + 273.15.
Para convertir de ºF a K use la fórmula: K = 5/9 (ºF – 32) + 273.15.
Para convertir de K a ºF use la fórmula:   ºF = 1.8(K – 273.15) + 32.*/

public class ConversionTemperatura {

    public double fahrenheitToCelsuis(double fahrenheit){
        return (fahrenheit-32)/1.80;
    }

    public double fahrenheitToKelvin(double fahrenheit){
        return ((fahrenheit + 459.67) * (0.555555556));
    }

    public double celciusToFahrenheit(double celsius){
        return ((celsius*1.8)+32);
    }
    public double celciusToKelvin(double celsius){
        return (celsius+273.15);
    }

    public double kelvinToCelcius(double kelvin){ return (kelvin-273.15);
    }

    public double kelvinToFahrenheit(double kelvin){
        return (1.8*(kelvin-273.15)+32);
    }


}
