package com.unit.converter.unitofmeasure;

import com.unit.converter.unitofmeasure.rest.UnitOfMeasureResource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LengthUnitOfMeasure extends UnitOfMeasure {

  public static final Double METRIC_TO_IMPERIAL_BASE_CONVERSION_FACTOR = 0.00109361;
  /**
   * An enum representing length Units.
   */
  enum UNIT {
    MM("Millimetre",true, 1.0), CM("Centimetre",true, 10.0),
    M("Metre", true, 1000.0), KM("Kilometre", true, 1000000.0),
    YARD("Yard", false, 1.0), INCH("Inch", false, 36.0),
    FT("Feet", false, 3.0), MILE("Mile", false, 0.000568182), ;

    private String name;
    private boolean isMetric;
    private Double baseUnitAmount;

    /**
     * An enum representing length Units.
     */
    UNIT(String name, Boolean isMetric, Double baseUnitAmount) {
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
