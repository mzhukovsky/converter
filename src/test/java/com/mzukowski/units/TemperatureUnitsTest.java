package com.mzukowski.units;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class TemperatureUnitsTest {

    @Autowired
    TemperatureUnits temperatureUnits;

    @Test
    public void forGivenUnitShouldBeFahrenheit() {
        //given
        String unit = "fahrenheit";

        //expect
        assertThat(temperatureUnits.getUnit(unit)).isEqualTo(TemperatureUnits.FAHRENHEIT);
    }

    @Test
    public void forGivenUnitShouldBecClsius() {
        //given
        String unit = "celsius";

        //expect
        assertThat(temperatureUnits.getUnit(unit)).isEqualTo(TemperatureUnits.CELSIUS);
    }

// TODO test metody getUnit w przpadku złej jednostki ?
}
