package com.unit.converter.unitofmeasure;

import com.unit.converter.unitofmeasure.rest.UnitOfMeasureResource;

import java.util.Arrays;
import java.util.List;

/**
 * Unit of Measure Interface.
 */
public abstract class UnitOfMeasure {

  protected Double fromUnitBaseAmount = 0.0;
  protected Double toUnitBaseAmount = 0.0;
  protected Boolean isFromUnitMetric = false;
  protected Boolean isToUnitMetric = false;
  protected Double metricBaseConversionFactor = 0.0;

  /**
   * Checks that the Unit of Measure is valid.
   * @param uom the Unit Of Measure
   * @return Bool
   */
  public Boolean isValidUOM(String uom, List<String> validUnits) {
    return validUnits.stream()
            .anyMatch(unit -> unit.toString().equals(uom));
  }

  /**
   * Retrieves the converstion Factor between unit.
   *
   * @param fromUnit the Unit being converted from
   * @param toUnit the Unit being converted to
   * @return conversionFactor
   *
   **/
  public Double getConversionFactor(String fromUnit, String toUnit) throws Exception {
    validateUnits(Arrays.asList(fromUnit, toUnit));
    // if the units are the same just return 1.0
    if (fromUnit.equals(toUnit)) {
      return 1.0;
    }
    setCalculationVariables(fromUnit, toUnit);

    if ((isFromUnitMetric && isToUnitMetric) || (!isFromUnitMetric && !isToUnitMetric)) {
      return fromUnitBaseAmount * toUnitBaseAmount;
    }
    else if (isFromUnitMetric && !isToUnitMetric) {
      return fromUnitBaseAmount * metricBaseConversionFactor * toUnitBaseAmount;
    }
    else {
      return fromUnitBaseAmount * (1 / metricBaseConversionFactor) / toUnitBaseAmount;
    }
  }

  public abstract void validateUnits(List<String> units) throws InvalidUnitOfMeasureException;

  /**
   * Sets variables needed for conversion calculation;
   * @param fromUnit
   * @param toUnit
   */
  protected abstract void setCalculationVariables(String fromUnit, String toUnit);
  /**
   * Retrieves the list of units.
   * @return @{@link List}
   */
  public abstract List<UnitOfMeasureResource> getUnitOfMeasureResourceList();

}
