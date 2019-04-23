package com.unit.converter.converter.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A representation of a conversation result.;
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConverterResource
{
  private Double value;
  private String fromUnit;
  private String toUnit;
  private Double result;

  /**
   * Default Constructor.
   */
  public ConverterResource(){}
  /**
   * THe constructor to instantiate.
   * @param result
   */

  public ConverterResource(String fromUnit, String toUnit, Double result) {
    setResult(result);
    setFromUnit(fromUnit);
    setToUnit(toUnit);
  }

  /**
   * Retrieves the value to convert
   * @return @{@link Double}
   */
  @JsonProperty("value")
  public Double getValue() {
    return value;
  }

  /**
   * Sets the value to convert.
   * @param value @{@link Double}
   */
  public void setValue(Double value) {
    this.value = value;
  }

  /**
   * Retrieves the unit to convert from.
   * @return @{@link String}
   */
  @JsonProperty("fromUnit")
  public String getFromUnit() {
    return fromUnit;
  }

  /**
   * Sets the unit to convert to.
   * @param fromUnit @{@link String}
   */
  public void setFromUnit(String fromUnit)
  {
    this.fromUnit = fromUnit;
  }

  /**
   * Retrieves the unit to convert to.
   * @return @{@link String}
   */
  @JsonProperty("toUnit")
  public String getToUnit() {
    return toUnit;
  }

  /**
   * Sets the to Unit to convert to.
   * @param toUnit @{@link String}
   */
  public void setToUnit(String toUnit) {
    this.toUnit = toUnit;
  }

  /**
   * Retrieves conversion result
   * @return @{@link Double}
   */
  @JsonProperty("result")
  public Double getResult() {
    return result;
  }

  /**
   * Sets the conversion result.
   * @param result @{@link Double}
   */
  public void setResult(Double result){
    this.result = result;
  }
}
