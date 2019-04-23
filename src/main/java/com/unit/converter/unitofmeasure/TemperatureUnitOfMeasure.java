package com.unit.converter.unitofmeasure;

import com.unit.converter.unitofmeasure.rest.UnitOfMeasureResource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents the temperature unit of measure.
 */
@Component
public class TemperatureUnitOfMeasure extends UnitOfMeasure
{
  /**
   * An enum representing temperature Units.
   */
  enum UNIT {
    CELSIUS("Celsius",true), FAHRENHEIT("Fahrenheit",false);
    private boolean isMetric;
    private String name;

    UNIT(String name, boolean isMetric) {
      this.name = name;
      this.isMetric = isMetric;
    }
  }

  @Override
  public void validateUnits(List<String> units) throws InvalidUnitOfMeasureException {
    List<String> validUOMs = Arrays.stream(UNIT.values())
            .map(unit -> unit.toString()).collect(Collectors.toList());
    if (units.stream().anyMatch(unit -> (!isValidUOM(unit, validUOMs)))){
      throw new InvalidUnitOfMeasureException(validUOMs);
    }
  }

  @Override
  public Double getConversionFactor(String fromUnit, String toUnit)
          throws Exception {
    throw new UnsupportedOperationException("Method not supported for Temperature Conversion");
  }
    @Override
  protected void setCalculationVariables(String fromUnit, String toUnit)
  {
    isFromUnitMetric = UNIT.valueOf(fromUnit).isMetric;
    isToUnitMetric = UNIT.valueOf(toUnit).isMetric;
  }

  @Override
  public List<UnitOfMeasureResource> getUnitOfMeasureResourceList() {
    return Arrays.stream(TemperatureUnitOfMeasure.UNIT.values()).map(unit -> {
      UnitOfMeasureResource resource = new UnitOfMeasureResource();
      resource.setUnit(unit.toString());
      resource.setName(unit.name);
      return resource;
    }).collect(Collectors.toList());
  }

  public Boolean isUnitMetric(String unit) {
    return UNIT.valueOf(unit).isMetric;
  }
}
