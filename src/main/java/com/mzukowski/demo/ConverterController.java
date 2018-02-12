package com.mzukowski.demo;

import com.mzukowski.descriptor.TemperatureConversionDescriptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ConverterController {

	private final TemperatureConversionDescriptor temperatureConversionDescriptor;

	@GetMapping("/celsius/{value}")
	public String getFahrenheit(@PathVariable double value) {
		return temperatureConversionDescriptor.describeConvertedToFahrenheit(value);
}

	@GetMapping("/fahrenheit/{value}")
	public String getCelsius(@PathVariable double value) {
		return temperatureConversionDescriptor.describeConvertedToCelsius(value);
	}
}
