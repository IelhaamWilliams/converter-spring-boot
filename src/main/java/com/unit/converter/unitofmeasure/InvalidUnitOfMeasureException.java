package com.unit.converter.unitofmeasure;

import java.util.List;

/**
 * Exception thrown when an UOM is invalid.
 */
public class InvalidUnitOfMeasureException extends Exception {
  private List<String> validUOMs;

  public InvalidUnitOfMeasureException(List<String> validUOMs) {
    this.validUOMs = validUOMs;
  }

  @Override
  public String getMessage() {
    return "An invalid UOM was given. Valid Unit Of Measure is " + validUOMs.toString();
  }
}
