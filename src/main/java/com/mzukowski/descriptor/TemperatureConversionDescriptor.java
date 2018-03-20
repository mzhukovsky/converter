package com.mzukowski.descriptor;

import com.mzukowski.units.TemperatureUnits;

public interface TemperatureConversionDescriptor {
    String describeConverted(double value);
    boolean matches(TemperatureUnits src, TemperatureUnits dsc);
}
