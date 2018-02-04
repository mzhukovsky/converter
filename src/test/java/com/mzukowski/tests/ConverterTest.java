package com.mzukowski.tests;

import org.junit.Test;

import com.mzukowski.util.Converter;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

	Converter conv = new Converter();
	
	@Test
	public void converterShouldReturn32F(){
		//given
		double celsius = 0;
		
		//expect
		assertThat(conv.convCelsiusToFahrenheit(celsius)).isEqualTo(32);
	}
	
	@Test
	public void converterShouldReturn100C(){
		//given
		double fahrenheit = 212;
		
		//expect
		assertThat(conv.convFahrenheitToCelsius(fahrenheit)).isEqualTo(100);
	}
}
