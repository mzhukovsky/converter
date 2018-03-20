package com.mzukowski.units;

import java.util.Arrays;

public enum TemperatureUnits {

    FAHRENHEIT("fahrenheit"),
    CELSIUS("celsius");

    private final String unit;

    TemperatureUnits(String unit) {
        this.unit = unit;
    }

    public static TemperatureUnits getUnit(String unit){
        return Arrays.stream(values())
                .filter(temperatureUnits -> temperatureUnits.unit.equalsIgnoreCase(unit))
                .findAny()
                .orElseThrow(()-> new IllegalStateException("Unit not found"));
    }
}



