package com.mzukowski.descriptor;


import com.mzukowski.units.TemperatureUnits;
import com.mzukowski.util.TemperatureConverter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CelsiusToFahrenheitConversionDescriptor implements TemperatureConversionDescriptor {

    @Autowired
    TemperatureConverter converter;

    @Override
    public String describeConverted(double value) {
        return value + " st. C to jest " + converter.convertCelsiusToFahrenheit(value) + " st. F";
    }

    @Override
    public boolean matches(TemperatureUnits sourceUnit, TemperatureUnits targetUnit) {
        if (sourceUnit.equals(TemperatureUnits.CELSIUS) && targetUnit.equals(TemperatureUnits.FAHRENHEIT))
            return true;
        return false;
    }
}
