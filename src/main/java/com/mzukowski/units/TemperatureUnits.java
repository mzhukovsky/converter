package com.mzukowski.units;

import lombok.experimental.FieldDefaults;

import static java.util.Arrays.stream;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
public enum TemperatureUnits {

    FAHRENHEIT("fahrenheit"),
    CELSIUS("celsius");

    String unit;

    TemperatureUnits(String unit) {
        this.unit = unit;
    }

    public static TemperatureUnits getUnit(String unit) {
        return stream(values())
                .filter(temperatureUnits -> temperatureUnits.isUnit(unit))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Unit not found"));
    }

    public boolean isUnit(String unitToVerify) {
        return unit.equalsIgnoreCase(unitToVerify);
    }
}
