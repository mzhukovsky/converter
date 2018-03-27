package com.mzukowski.descriptor;

import com.mzukowski.units.TemperatureUnits;
import com.mzukowski.util.TemperatureConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static com.mzukowski.units.TemperatureUnits.CELSIUS;
import static com.mzukowski.units.TemperatureUnits.FAHRENHEIT;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class CelsiusToFahrenheitConversionDescriptorTest {

    TemperatureConverter converter = mock(TemperatureConverter.class);

    CelsiusToFahrenheitConversionDescriptor celsiusToFahrenheitConversionDescriptor =
            new CelsiusToFahrenheitConversionDescriptor(converter);

    private boolean expectedResult;

    private TemperatureUnits sourceUnit;

    private TemperatureUnits targetUnit;

    public CelsiusToFahrenheitConversionDescriptorTest(boolean expectedResult,
                                                       TemperatureUnits sourceUnit,
                                                       TemperatureUnits targetUnit) {
        this.expectedResult = expectedResult;
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        Object[][] data = new Object[][]{
                {true, CELSIUS, FAHRENHEIT},
                {false, FAHRENHEIT, CELSIUS}
        };
        return asList(data);
    }

    @Test
    public void expectMatchingResultThisIsItOfSourceUnitAndTargetUnit() {
        //expect
        assertThat(celsiusToFahrenheitConversionDescriptor.matches(sourceUnit, targetUnit))
                .isEqualTo(expectedResult);
    }

    @Test
    public void descriptorShouldReturn32F() {
        // given
        double temperatureCelsius = 0.0;
        when(converter.convertCelsiusToFahrenheit(eq(temperatureCelsius))).thenReturn(32.0);

        //expect
        assertThat(celsiusToFahrenheitConversionDescriptor.describeConverted(temperatureCelsius))
                .isEqualTo(temperatureCelsius + " st. C to jest 32.0 st. F");
    }
}
