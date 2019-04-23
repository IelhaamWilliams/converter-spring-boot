package com.unit.converter.unitofmeasure.rest;

/**
 * A representation of a Unit of Measure Resource;
 */
public class UnitOfMeasureResource {
  private String unit;
  private String name;

  /**
   * Retrieves the unit of measure.
   * @return unit
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Sets the unit of measure.
   * @param unit the unit
   */
  public void setUnit(String unit) {
    this.unit = unit;
  }

  /**
   * Retrieves the name of the unit.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name.
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }
}
