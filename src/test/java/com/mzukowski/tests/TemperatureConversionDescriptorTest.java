package com.mzukowski.tests;

import com.mzukowski.descriptor.TemperatureConversionDescriptor;
import com.mzukowski.util.TemperatureConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class TemperatureConversionDescriptorTest {

    TemperatureConversionDescriptor temperatureConversionDescriptor;

    @Mock
    TemperatureConverter converter;

    @Before
    public void setUp() {
        initMocks(this);
        temperatureConversionDescriptor = new TemperatureConversionDescriptor(converter);
    }

    @Test
    public void descriptorShouldReturn32F() {
        // given
        double temperatureCelcius = 0.0;
        when(converter.convertCelsiusToFahrenheit(eq(temperatureCelcius))).thenReturn(32.0);

        //expect
        assertThat(temperatureConversionDescriptor.describeConvertedToFahrenheit(temperatureCelcius))
                .isEqualTo(temperatureCelcius + " st. C to jest 32.0 st. F");
    }

    @Test
    public void descriptorShouldReturn100C() {
        // given
        double temperatureFahrenheit = 212.0;
        when(converter.convertFahrenheitToCelsius(eq(temperatureFahrenheit))).thenReturn(100.0);

        //expect
        assertThat(temperatureConversionDescriptor.describeConvertedToCelsius(temperatureFahrenheit))
                .isEqualTo(temperatureFahrenheit + " st. F to jest 100.0 st. C");
    }
}
