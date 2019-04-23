package com.unit.converter.unitofmeasure;

import com.unit.converter.unitofmeasure.rest.UnitOfMeasureResource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LengthUnitOfMeasureTest {

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testAUnitIsValidReturnsFalse() {
    UnitOfMeasure unitOfMeasure = new LengthUnitOfMeasure();
     boolean result = unitOfMeasure.isValidUOM("B", Arrays.asList("M", "MM", "INCH", "FT"));
     assertFalse(result);
  }

  @Test
  public void testAUnitIsValidReturnsTrue() {
    UnitOfMeasure unitOfMeasure = new LengthUnitOfMeasure();
    boolean result = unitOfMeasure.isValidUOM("INCH", Arrays.asList("M", "MM", "INCH", "FT"));
    assertTrue(result);
  }

  @Test(expected = InvalidUnitOfMeasureException.class)
  public void testAListOfUnitIsValidthrowsException() throws InvalidUnitOfMeasureException {
    UnitOfMeasure unitOfMeasure = new LengthUnitOfMeasure();
    unitOfMeasure.validateUnits(Arrays.asList("M", "B", "INCH", "FT"));
  }

  @Test
  public void testAListOfUnitIsValidthrowsNoException() throws InvalidUnitOfMeasureException {
    UnitOfMeasure unitOfMeasure = new LengthUnitOfMeasure();
    unitOfMeasure.validateUnits(Arrays.asList("M", "MM", "INCH", "FT"));
  }

  @Test
  public void testGetUnitOfMeasureResourceList() {
    UnitOfMeasure unitOfMeasure = new LengthUnitOfMeasure();
    List<UnitOfMeasureResource> resources = unitOfMeasure.getUnitOfMeasureResourceList();

    assertEquals(8, resources.size());
    assertEquals("MM", resources.get(0).getUnit());
    assertEquals("Millimetre", resources.get(0).getName());
  }

  @Test
  public void testGetConversionFactorForMetricToMetricConversion() throws Exception {
    UnitOfMeasure unitOfMeasure = new LengthUnitOfMeasure();
    Double result = unitOfMeasure.getConversionFactor("MM","CM");

    assertEquals(10.0, result.doubleValue(), 0);
  }

  @Test
  public void testGetConversionFactorForMetricToImperialConversion() throws Exception {
    UnitOfMeasure unitOfMeasure = new LengthUnitOfMeasure();
    Double result = unitOfMeasure.getConversionFactor("M","FT");

    assertEquals(3.28, new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue(), 0);
  }

  @Test
  public void testGetConversionFactorForImperialToMetricConversion() throws Exception {
    UnitOfMeasure unitOfMeasure = new LengthUnitOfMeasure();
    Double result = unitOfMeasure.getConversionFactor("YARD","CM");

    assertEquals(91.44, new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue(), 0);

  }

  @Test
  public void testGetConversionFactorForImperialToImperialConversion() throws Exception {
    UnitOfMeasure unitOfMeasure = new LengthUnitOfMeasure();
    Double result = unitOfMeasure.getConversionFactor("YARD","FT");

    assertEquals(3, new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue(), 0);
  }
}
