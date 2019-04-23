package com.unit.converter.converter;

import com.unit.converter.unitofmeasure.MassUnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MassConverterTest {

  @Mock MassUnitOfMeasure mockUnitOfMeasure;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testConvert() throws Exception{

    when(mockUnitOfMeasure.getConversionFactor("G", "KG")).thenReturn(10.0);

    Converter converter = new MassConverter(mockUnitOfMeasure);
    Double result = converter.convert(5.0, "G", "KG");
    assertEquals(50.0, result.doubleValue(), 0);
  }
}
