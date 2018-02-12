package com.mzukowski.util;

import org.springframework.stereotype.Service;

@Service
public class TemperatureConverter {

    private static final double CELCIUS_FARENHEIT_RATIO = 1.8;
    private static final int WATER_FROZEN_TEMPERATURE_IN_FAHRENHEIT = 32;
	
    public double convertCelsiusToFahrenheit(double celsius) {
        return celsius * CELCIUS_FARENHEIT_RATIO + WATER_FROZEN_TEMPERATURE_IN_FAHRENHEIT;
    }

    public double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - WATER_FROZEN_TEMPERATURE_IN_FAHRENHEIT) / CELCIUS_FARENHEIT_RATIO;
    }
}
