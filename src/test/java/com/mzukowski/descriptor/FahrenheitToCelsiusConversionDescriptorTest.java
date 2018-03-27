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
public class FahrenheitToCelsiusConversionDescriptorTest {

    TemperatureConverter converter = mock(TemperatureConverter.class);

    FahrenheitToCelsiusConversionDescriptor fahrenheitToCelsiusConversionDescriptor =
            new FahrenheitToCelsiusConversionDescriptor(converter);

    private boolean expectedResult;

    private TemperatureUnits sourceUnit;

    private TemperatureUnits targetUnit;

    public FahrenheitToCelsiusConversionDescriptorTest(boolean expectedResult,
                                                       TemperatureUnits sourceUnit,
                                                       TemperatureUnits targetUnit) {
        this.expectedResult = expectedResult;
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        Object[][] data1 = new Object[][]{
                {true, FAHRENHEIT, CELSIUS},
                {false, CELSIUS, FAHRENHEIT}
        };
        return asList(data1);
    }

    @Test
    public void expectMatchingResultThisIsItOfSourceUnitAndTargetUnit() {
        //expect
        assertThat(fahrenheitToCelsiusConversionDescriptor.matches(sourceUnit, targetUnit))
                .isEqualTo(expectedResult);
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
}
