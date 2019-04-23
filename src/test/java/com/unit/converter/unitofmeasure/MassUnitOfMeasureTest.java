package com.unit.converter.unitofmeasure;

import com.unit.converter.unitofmeasure.rest.UnitOfMeasureResource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MassUnitOfMeasureTest {

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testAUnitIsValidReturnsFalse() {
    UnitOfMeasure unitOfMeasure = new MassUnitOfMeasure();
    boolean result = unitOfMeasure.isValidUOM("B", Arrays.asList("G", "KG", "LB"));
    assertFalse(result);
  }

  @Test
  public void testAUnitIsValidReturnsTrue() {
    UnitOfMeasure unitOfMeasure = new MassUnitOfMeasure();
    boolean result = unitOfMeasure.isValidUOM("KG", Arrays.asList("G", "KG", "LB", "OZ"));
    assertTrue(result);
  }

  @Test(expected = InvalidUnitOfMeasureException.class)
  public void testAListOfUnitIsValidthrowsException() throws InvalidUnitOfMeasureException {
    UnitOfMeasure unitOfMeasure = new MassUnitOfMeasure();
    unitOfMeasure.validateUnits(Arrays.asList("G", "B", "LB", "KG"));
  }

  @Test
  public void testAListOfUnitIsValidthrowsNoException() throws InvalidUnitOfMeasureException {
    UnitOfMeasure unitOfMeasure = new MassUnitOfMeasure();
    unitOfMeasure.validateUnits(Arrays.asList("G", "KG", "OZ", "LB"));
  }

  @Test
  public void testGetUnitOfMeasureResourceList() {
    UnitOfMeasure unitOfMeasure = new MassUnitOfMeasure();
    List<UnitOfMeasureResource> resources = unitOfMeasure.getUnitOfMeasureResourceList();

    assertEquals(4, resources.size());
    assertEquals("G", resources.get(0).getUnit());
    assertEquals("Gram", resources.get(0).getName());
  }

  @Test
  public void testGetConversionFactorForMetricToMetricConversion() throws Exception {
    UnitOfMeasure unitOfMeasure = new MassUnitOfMeasure();
    Double result = unitOfMeasure.getConversionFactor("KG","G");

    assertEquals(1000.0, result.doubleValue(), 0);
  }

  @Test
  public void testGetConversionFactorForMetricToImperialConversion() throws Exception {
    UnitOfMeasure unitOfMeasure = new MassUnitOfMeasure();
    Double result = unitOfMeasure.getConversionFactor("KG","OZ");

    assertEquals(35.27, new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue(), 0);
  }

  @Test
  public void testGetConversionFactorForImperialToMetricConversion() throws Exception {
    UnitOfMeasure unitOfMeasure = new MassUnitOfMeasure();
    Double result = unitOfMeasure.getConversionFactor("LB","KG");

    assertEquals(0.45, new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue(), 0);

  }

  @Test
  public void testGetConversionFactorForImperialToImperialConversion() throws Exception {
    UnitOfMeasure unitOfMeasure = new MassUnitOfMeasure();
    Double result = unitOfMeasure.getConversionFactor("LB","OZ");

    assertEquals(16.0, result, 0);
  }
}
