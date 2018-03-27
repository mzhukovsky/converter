package com.mzukowski.controller;

import com.mzukowski.provider.TemperatureConversionDescriptorProvider;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mzukowski.units.TemperatureUnits.getUnit;
import static lombok.AccessLevel.PRIVATE;

@RequestMapping("/convert")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ConverterController {

    TemperatureConversionDescriptorProvider temperatureConversionDescriptorProvider;

    @GetMapping("/{sourceUnit}/{valueInSourceUnit}/to-{destinationUnit}")
    public HttpEntity<String> getConversionDescription(@PathVariable String sourceUnit,
                                                       @PathVariable double valueInSourceUnit,
                                                       @PathVariable String destinationUnit) {
        return ResponseEntity.ok(temperatureConversionDescriptorProvider
                .getTemperatureConversionDescriptor(getUnit(sourceUnit), getUnit(destinationUnit))
                .describeConverted(valueInSourceUnit));
    }
}