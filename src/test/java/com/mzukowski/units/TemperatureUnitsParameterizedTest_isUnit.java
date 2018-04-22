package com.mzukowski.units;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static com.mzukowski.units.TemperatureUnits.CELSIUS;
import static com.mzukowski.units.TemperatureUnits.FAHRENHEIT;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class TemperatureUnitsParameterizedTest_isUnit {

    private boolean expectedResult;

    private TemperatureUnits callUnit;

    private String givenUnit;

    public TemperatureUnitsParameterizedTest_isUnit(boolean expectedResult,
                                                    TemperatureUnits callUnit,
                                                    String givenUnit) {
        this.expectedResult = expectedResult;
        this.callUnit = callUnit;
        this.givenUnit = givenUnit;
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return asList(new Object[][]{
                {true, FAHRENHEIT, "fahrenheit"},
                {true, CELSIUS, "celsius"},
                {false, FAHRENHEIT, "celsius"},
                {false, CELSIUS, "fahrenheit"}
        });
    }

    @Test
    public void expectMatchingResultForGivenUnitAndCallUnit() {
        //expect
        assertThat(callUnit.isUnit(givenUnit)).isEqualTo(expectedResult);
    }
}
