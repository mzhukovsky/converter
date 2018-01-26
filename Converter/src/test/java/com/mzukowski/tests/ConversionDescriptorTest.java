package com.mzukowski.tests;

import com.mzukowski.descriptor.ConversionDescriptor;
import com.mzukowski.util.Converter;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionDescriptorTest {
    Converter conv = new Converter();

    @Test
    public void descriptorShouldReturn32F(){
        //prepare
        ConversionDescriptor cd = new ConversionDescriptor(conv);
        //given
        double celsius = 0;
        //expect
        assertThat(cd.convertCelsiusToFahrenheitAndDescribe(celsius)).isEqualTo("0.0 st. C to jest 32.0 st. F");
    }

    @Test
    public void descriptorShouldReturn100C(){
        //prepare
        ConversionDescriptor cd = new ConversionDescriptor(conv);
        //given
        double fahrenheit = 212.0;
        //expect
        assertThat(cd.convertFahrenheitToCelsiusAndDescribe(fahrenheit)).isEqualTo("212.0 st. F to jest 100.0 st. C");
    }
}
