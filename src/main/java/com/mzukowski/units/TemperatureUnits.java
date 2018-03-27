package com.mzukowski.units;

import java.util.Arrays;

public enum TemperatureUnits {

    FAHRENHEIT("fahrenheit"),
    CELSIUS("celsius");

    private final String unit;

    TemperatureUnits(String unit) {
        this.unit = unit;
    }

    public static TemperatureUnits getUnit(String unit) {
        return Arrays.stream(values())
                .filter(temperatureUnits -> temperatureUnits.isUnit(unit))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Unit not found"));
    }

    public boolean isUnit(String unitToVerify) {
        return unit.equalsIgnoreCase(unitToVerify);
    }
}
