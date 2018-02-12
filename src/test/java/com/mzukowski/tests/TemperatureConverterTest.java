package com.mzukowski.tests;

import org.junit.Test;

import com.mzukowski.util.TemperatureConverter;

import static org.assertj.core.api.Assertions.assertThat;

public class TemperatureConverterTest {

	TemperatureConverter conv = new TemperatureConverter();
	
	@Test
	public void converterShouldReturn32F(){
		//given
		double celsius = 0;
		
		//expect
		assertThat(conv.convertCelsiusToFahrenheit(celsius)).isEqualTo(32);
	}
	
	@Test
	public void converterShouldReturn100C(){
		//given
		double fahrenheit = 212;
		
		//expect
		assertThat(conv.convertFahrenheitToCelsius(fahrenheit)).isEqualTo(100);
	}
}
