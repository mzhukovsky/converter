package com.mzukowski.descriptor;

import com.mzukowski.units.TemperatureUnits;
import com.mzukowski.util.TemperatureConverter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.mzukowski.units.TemperatureUnits.CELSIUS;
import static com.mzukowski.units.TemperatureUnits.FAHRENHEIT;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class FahrenheitToCelsiusConversionDescriptor implements TemperatureConversionDescriptor {

    TemperatureConverter converter;

    @Override
    public String describeConverted(double value) {
        return value + " st. F to jest " + converter.convertFahrenheitToCelsius(value) + " st. C";
    }

    @Override
    public boolean matches(TemperatureUnits sourceUnit, TemperatureUnits targetUnit) {
        return sourceUnit == FAHRENHEIT && targetUnit == CELSIUS;
    }
}
