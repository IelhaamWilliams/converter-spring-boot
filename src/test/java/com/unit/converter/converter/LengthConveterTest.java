package com.unit.converter.converter;

import com.unit.converter.unitofmeasure.LengthUnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

public class LengthConveterTest {
  @Mock LengthUnitOfMeasure mockUnitOfMeasure;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testConvert() throws Exception{

    when(mockUnitOfMeasure.getConversionFactor("M", "MM")).thenReturn(10.0);

    Converter converter = new LengthConverter(mockUnitOfMeasure);
    Double result = converter.convert(5.0, "M", "MM");
    assertEquals(50.0, result.doubleValue(), 0);
  }
}
