package com.mzukowski.util;

import org.springframework.stereotype.Service;

@Service
public class Converter {

    private static final double CONSTANT1 = 1.8;
    private static final int CONSTANT2 = 32;
	
    public double convCelsiusToFahrenheit(double celsius) {
        return celsius * CONSTANT1 + CONSTANT2;
    }

    public double convFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - CONSTANT2) / CONSTANT1;
    }
}
