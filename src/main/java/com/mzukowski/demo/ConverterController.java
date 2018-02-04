package com.mzukowski.demo;

import com.mzukowski.descriptor.ConversionDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

	private final ConversionDescriptor conversionDescriptor; // czy to nie powinno być interfejsem ?

	@Autowired
	public ConverterController(ConversionDescriptor conversionDescriptor) {
		this.conversionDescriptor = conversionDescriptor;
	}

	@RequestMapping("/celsius/{value}")
	@GetMapping
	public String getFahrenheit(@PathVariable("value") double value) {
		return conversionDescriptor.convertCelsiusToFahrenheitAndDescribe(value);
	}
	
	@RequestMapping("/fahrenheit/{value}")
	@GetMapping
	public String getCelsius(@PathVariable("value") double value) {
		return conversionDescriptor.convertFahrenheitToCelsiusAndDescribe(value);
	}
}
