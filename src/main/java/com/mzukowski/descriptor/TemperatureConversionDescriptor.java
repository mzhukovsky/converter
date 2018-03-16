package com.mzukowski.descriptor;

import com.mzukowski.util.TemperatureConverter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TemperatureConversionDescriptor {

    @Autowired
    TemperatureConverter converter;

    public String describeConvertedToFahrenheit(double celsius) {
        return celsius + " st. C to jest " + converter.convertCelsiusToFahrenheit(celsius) + " st. F";
    }

    public String describeConvertedToCelsius(double fahrenheit) {
        return fahrenheit + " st. F to jest " + converter.convertFahrenheitToCelsius(fahrenheit) + " st. C";
    }
}