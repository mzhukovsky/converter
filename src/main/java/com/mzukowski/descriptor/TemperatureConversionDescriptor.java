package com.mzukowski.descriptor;

import com.mzukowski.util.TemperatureConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TemperatureConversionDescriptor {

	private final TemperatureConverter converter;

	public String describeConvertedToFahrenheit(double celsius){
		return celsius+" st. C to jest "+converter.convertCelsiusToFahrenheit(celsius)+" st. F";
	}
	
	public String describeConvertedToCelsius(double fahrenheit){
		return fahrenheit+" st. F to jest "+converter.convertFahrenheitToCelsius(fahrenheit)+" st. C";
	}

}
