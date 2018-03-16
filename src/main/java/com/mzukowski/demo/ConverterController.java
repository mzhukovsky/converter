package com.mzukowski.demo;

import com.mzukowski.descriptor.TemperatureConversionDescriptor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
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
    TemperatureConversionDescriptor temperatureConversionDescriptor;

    @GetMapping("/{sourceUnit}/{valueInSourceUnit}/to-{destinationUnit}")
    public HttpEntity<String> getFahrenheit(@PathVariable String sourceUnit,
                                            @PathVariable double valueInSourceUnit,
                                            @PathVariable String destinationUnit) {

        if (sourceUnit.equals("celsius") && destinationUnit.equals("fahrenheit")) {
            return ResponseEntity.ok(temperatureConversionDescriptor.describeConvertedToFahrenheit(valueInSourceUnit));
        }
        if (sourceUnit.equals("fahrenheit") && destinationUnit.equals("celsius")) {
            return ResponseEntity.ok(temperatureConversionDescriptor.describeConvertedToCelsius(valueInSourceUnit));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}