package com.mzukowski.util;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class TemperatureConverterTest {

    @Autowired
    TemperatureConverter conv = new TemperatureConverter();

    @Test
    public void afterConverted0CelsiusItsShouldBe32Fahrenheit() {
        //given
        double celsius = 0;

        //expect
        assertThat(conv.convertCelsiusToFahrenheit(celsius)).isEqualTo(32);
    }

    @Test
    public void afterConverted212FahrenheitShouldBe100Celsius() {
        //given
        double fahrenheit = 212;

        //expect
        assertThat(conv.convertFahrenheitToCelsius(fahrenheit)).isEqualTo(100);
    }
}
