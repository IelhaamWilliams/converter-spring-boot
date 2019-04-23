package com.unit.converter.converter;

import com.unit.converter.unitofmeasure.UnitOfMeasure;

/**
 * Converter Interface.
 */
public abstract class Converter {

  private UnitOfMeasure unitOfMeasure;

  public Converter(UnitOfMeasure unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }
  /**
   * Converts metric to imperial, vice versa, metric to metric or
   * imperial to imperial.
   * @param value the value to convert
   * @param fromUnit the unit to convert from
   * @param toUnit the unit to convert to
   * @return Double representing answer
   */
   public Double convert(Double value, String fromUnit, String toUnit ) throws Exception {
     return value * unitOfMeasure.getConversionFactor(fromUnit, toUnit);
   }
}
