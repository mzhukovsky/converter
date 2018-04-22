package com.mzukowski.provider;

import com.mzukowski.descriptor.TemperatureConversionDescriptor;
import com.mzukowski.units.TemperatureUnits;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TemperatureConversionDescriptorProvider {

    Collection<TemperatureConversionDescriptor> conversionDescriptorsList;

    public TemperatureConversionDescriptor getTemperatureConversionDescriptor(TemperatureUnits sourceUnit, TemperatureUnits targetUnit) {
        return conversionDescriptorsList
                .stream()
                .filter(temperatureConversionDescriptor -> temperatureConversionDescriptor.matches(sourceUnit, targetUnit))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Descriptor not found for source unit "+sourceUnit +" and destination unit "+targetUnit));
    }
}
