package com.unit.converter.converter;

import com.unit.converter.unitofmeasure.LengthUnitOfMeasure;
import com.unit.converter.unitofmeasure.TemperatureUnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TemperatureConverterTest {

  @Mock TemperatureUnitOfMeasure mockUnitOfMeasure;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testConvertWhenFromUnitIsEqualToUnit() throws Exception{
    Converter converter = new TemperatureConverter(mockUnitOfMeasure);
    Double result = converter.convert(5.0, "FAHRENHEIT", "FAHRENHEIT");
    assertEquals(5.0, result.doubleValue(), 0);
  }

  @Test
  public void testConvertFromMetricToImperial() throws Exception{
    when(mockUnitOfMeasure.isUnitMetric("CELSIUS")).thenReturn(true);
    when(mockUnitOfMeasure.isUnitMetric("FAHRENHEIT")).thenReturn(false);

    Converter converter = new TemperatureConverter(mockUnitOfMeasure);
    Double result = converter.convert(5.0, "CELSIUS", "FAHRENHEIT");
    assertEquals(41.0, result.doubleValue(), 0);
  }

  @Test
  public void testConvertFromImperialToMetric() throws Exception{
    when(mockUnitOfMeasure.isUnitMetric("CELSIUS")).thenReturn(true);
    when(mockUnitOfMeasure.isUnitMetric("FAHRENHEIT")).thenReturn(false);

    Converter converter = new TemperatureConverter(mockUnitOfMeasure);
    Double result = converter.convert(5.0, "FAHRENHEIT", "CELSIUS");
    assertEquals(-15.0, result.doubleValue(), 0);
  }
}
