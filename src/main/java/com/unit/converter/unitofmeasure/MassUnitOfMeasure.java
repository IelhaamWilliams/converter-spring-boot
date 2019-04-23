package com.unit.converter.unitofmeasure;

import com.unit.converter.unitofmeasure.rest.UnitOfMeasureResource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MassUnitOfMeasure extends UnitOfMeasure {

  public static final Double METRIC_TO_IMPERIAL_BASE_CONVERSION_FACTOR = 0.035274;

  /**
   * An enum representing mass Units.
   */
  enum UNIT
  {
    G("Gram", true, 1.0),
    KG("Kilogram", true, 1000.0), OZ("Ounce", false, 1.0),
    LB("Pound", false, 16.0);

    private String name;
    private boolean isMetric;
    private Double baseUnitAmount;

    UNIT(String name, Boolean isMetric, Double baseUnitAmount)
    {
      this.name = name;
      this.isMetric = isMetric;
      this.baseUnitAmount = baseUnitAmount;
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
  protected void setCalculationVariables(String fromUnit, String toUnit) {
    fromUnitBaseAmount = UNIT.valueOf(fromUnit).baseUnitAmount;
    toUnitBaseAmount = UNIT.valueOf(toUnit).baseUnitAmount;
    isFromUnitMetric = UNIT.valueOf(fromUnit).isMetric;
    isToUnitMetric = UNIT.valueOf(toUnit).isMetric;
    metricBaseConversionFactor = METRIC_TO_IMPERIAL_BASE_CONVERSION_FACTOR;
  }

  @Override
  public List<UnitOfMeasureResource> getUnitOfMeasureResourceList() {
    return Arrays.stream(UNIT.values()).map(unit -> {
      UnitOfMeasureResource resource = new UnitOfMeasureResource();
      resource.setUnit(unit.toString());
      resource.setName(unit.name);
      return resource;
    }).collect(Collectors.toList());
  }
}
