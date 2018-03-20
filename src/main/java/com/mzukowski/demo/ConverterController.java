package com.mzukowski.demo;

import com.mzukowski.factory.TemperatureConversionDescriptorFactory;
import com.mzukowski.units.TemperatureUnits;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;

@RequestMapping("/convert")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ConverterController {

    @Autowired
    TemperatureConversionDescriptorFactory temperatureConversionDescriptorFactory;

    @GetMapping("/{sourceUnit}/{valueInSourceUnit}/to-{destinationUnit}")
    public HttpEntity<String> getConversionDescription(@PathVariable String sourceUnit,
                                            @PathVariable double valueInSourceUnit,
                                            @PathVariable String destinationUnit) {
        return ResponseEntity.ok(temperatureConversionDescriptorFactory
                .getTemperatureConversionDescriptor(
                        TemperatureUnits.getUnit(sourceUnit), TemperatureUnits.getUnit(destinationUnit))
                .describeConverted(valueInSourceUnit));
    }
}