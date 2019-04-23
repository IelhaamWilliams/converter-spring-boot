package com.unit.converter.converter;

import com.unit.converter.unitofmeasure.LengthUnitOfMeasure;
import org.springframework.stereotype.Component;

/**
 * Length converter class.
 */
@Component
public class LengthConverter extends Converter {

  /**
   * Constructor used for instantiation.
   * @param lengthUnitOfMeasure @{@link LengthUnitOfMeasure}
   */
  public LengthConverter(LengthUnitOfMeasure lengthUnitOfMeasure) {
    super(lengthUnitOfMeasure);
  }

}
