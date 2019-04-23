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

public class TemperatureUnitOfMeasureTest {
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testAUnitIsValidReturnsFalse() {
    UnitOfMeasure unitOfMeasure = new TemperatureUnitOfMeasure();
    boolean result = unitOfMeasure.isValidUOM("B", Arrays.asList("CELSIUS", "FAHRENHEIT"));
    assertFalse(result);
  }

  @Test
  public void testAUnitIsValidReturnsTrue() {
    UnitOfMeasure unitOfMeasure = new TemperatureUnitOfMeasure();
    boolean result = unitOfMeasure.isValidUOM("FAHRENHEIT", Arrays.asList("CELSIUS", "FAHRENHEIT"));
    assertTrue(result);
  }

  @Test(expected = InvalidUnitOfMeasureException.class)
  public void testAListOfUnitIsValidthrowsException() throws InvalidUnitOfMeasureException {
    UnitOfMeasure unitOfMeasure = new TemperatureUnitOfMeasure();
    unitOfMeasure.validateUnits(Arrays.asList("B", "FAHRENHEIT"));
  }

  @Test
  public void testAListOfUnitIsValidthrowsNoException() throws InvalidUnitOfMeasureException {
    UnitOfMeasure unitOfMeasure = new TemperatureUnitOfMeasure();
    unitOfMeasure.validateUnits(Arrays.asList("CELSIUS", "FAHRENHEIT"));
  }

  @Test
  public void testGetUnitOfMeasureResourceList() {
    UnitOfMeasure unitOfMeasure = new TemperatureUnitOfMeasure();
    List<UnitOfMeasureResource> resources = unitOfMeasure.getUnitOfMeasureResourceList();

    assertEquals(2, resources.size());
    assertEquals("CELSIUS", resources.get(0).getUnit());
    assertEquals("Celsius", resources.get(0).getName());
  }
}
