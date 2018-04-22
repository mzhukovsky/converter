package com.mzukowski.units;

import org.junit.Test;

import static com.mzukowski.units.TemperatureUnits.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TemperatureUnitsTest_getUnit {

    @Test
    public void testException() {
        //given
        String unit = "omega";

        //expect
        assertThatThrownBy(() -> getUnit(unit)).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Unit not found");
    }

    @Test
    public void forGivenUnitShouldBeFahrenheit() {
        //given
        String unit = "fahrenheit";

        //expect
        assertThat(getUnit(unit)).isEqualTo(FAHRENHEIT);
    }
}