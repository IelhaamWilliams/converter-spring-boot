package com.unit.converter.converter;

import com.unit.converter.unitofmeasure.TemperatureUnitOfMeasure;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Temperature converter class.
 */
@Component
public class TemperatureConverter  extends Converter {
  private TemperatureUnitOfMeasure temperatureUnitOfMeasure;
   /**
   * Constructor used for instantiation.
   * @param temperatureUnitofMeasure @{@link TemperatureUnitOfMeasure}
   */
  public TemperatureConverter(TemperatureUnitOfMeasure temperatureUnitofMeasure)  {
    super(temperatureUnitofMeasure);
    this.temperatureUnitOfMeasure = temperatureUnitofMeasure;
  }

  @Override
  public Double convert(Double value, String fromUnit, String toUnit ) throws Exception {
    //Temperature conversion is a bit different so not using conversion factor.
    temperatureUnitOfMeasure.validateUnits(Arrays.asList(fromUnit, toUnit));
    if (fromUnit.equals(toUnit)) {
      return value;
    }
    return (temperatureUnitOfMeasure.isUnitMetric(fromUnit)
                    && !temperatureUnitOfMeasure.isUnitMetric(toUnit))?
            (value * 5/9) + 32 : (value - 32) * 5/9;
  }
}
