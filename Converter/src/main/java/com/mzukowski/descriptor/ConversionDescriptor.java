package com.mzukowski.descriptor;

import com.mzukowski.util.Converter;
import org.springframework.stereotype.Service;

@Service
public class ConversionDescriptor {

	private final Converter converter;

	public ConversionDescriptor(Converter converter) {
		this.converter = converter;
	}

	public String convertCelsiusToFahrenheitAndDescribe(double celsius){
		return celsius+" st. C to jest "+converter.convCelsiusToFahrenheit(celsius)+" st. F";
	}
	
	public String convertFahrenheitToCelsiusAndDescribe(double fahrenheit){
		return fahrenheit+" st. F to jest "+converter.convFahrenheitToCelsius(fahrenheit)+" st. C";
	}

}