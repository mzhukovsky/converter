package com.mzukowski.descriptor;

import com.mzukowski.units.TemperatureUnits;
import com.mzukowski.util.TemperatureConverter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CelsiusToFahrenheitConversionDescriptorTest {

    @Autowired
    CelsiusToFahrenheitConversionDescriptor celsiusToFahrenheitConversionDescriptor;

    @Mock
    TemperatureConverter converter;

    @Before
    public void setUp() {
        initMocks(this);
        celsiusToFahrenheitConversionDescriptor = new CelsiusToFahrenheitConversionDescriptor(converter);
    }

    @Test
    public void descriptorShouldReturn32F() {
        // given
        double temperatureCelcius = 0.0;
        Mockito.when(converter.convertCelsiusToFahrenheit(Matchers.eq(temperatureCelcius))).thenReturn(32.0);

        //expect
        assertThat(celsiusToFahrenheitConversionDescriptor.describeConverted(temperatureCelcius))
                .isEqualTo(temperatureCelcius + " st. C to jest 32.0 st. F");
    }

    @Test
    public void matchesShouldReturnTrue() {
        // given
        TemperatureUnits sourceUnit = TemperatureUnits.CELSIUS;
        TemperatureUnits targetUnit = TemperatureUnits.FAHRENHEIT;

        //expect
        assertThat(celsiusToFahrenheitConversionDescriptor.matches(sourceUnit, targetUnit))
                .isEqualTo(true);
    }
}
