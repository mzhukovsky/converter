package com.mzukowski.descriptor;

import com.mzukowski.units.TemperatureUnits;
import com.mzukowski.util.TemperatureConverter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class FahrenheitToCelsiusConversionDescriptorTest {

    @Autowired
    FahrenheitToCelsiusConversionDescriptor fahrenheitToCelsiusConversionDescriptor;

    @Mock
    TemperatureConverter converter;

    @Before
    public void setUp() {
        initMocks(this);
        fahrenheitToCelsiusConversionDescriptor = new FahrenheitToCelsiusConversionDescriptor(converter);
    }

    @Test
    public void descriptorShouldReturn100C() {
        // given
        double temperatureFahrenheit = 212.0;
        when(converter.convertFahrenheitToCelsius(eq(temperatureFahrenheit))).thenReturn(100.0);

        //expect
        assertThat(fahrenheitToCelsiusConversionDescriptor.describeConverted(temperatureFahrenheit))
                .isEqualTo(temperatureFahrenheit + " st. F to jest 100.0 st. C");
    }

    @Test
    // czy to powinno być testowane w TemperatureConversionDescriptorFactory ? Czy testować też matchesShouldReturnFalse ?
    public void matchesShouldReturnTrue() {
        // given
        TemperatureUnits sourceUnit = TemperatureUnits.FAHRENHEIT;
        TemperatureUnits targetUnit = TemperatureUnits.CELSIUS;

        //expect
        assertThat(fahrenheitToCelsiusConversionDescriptor.matches(sourceUnit, targetUnit))
                .isEqualTo(true);
    }
}
