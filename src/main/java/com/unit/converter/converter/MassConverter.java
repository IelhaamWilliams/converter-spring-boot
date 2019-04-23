package com.unit.converter.converter;

import com.unit.converter.unitofmeasure.MassUnitOfMeasure;
import org.springframework.stereotype.Component;

/**
 * Mass converter class.
 */
@Component
public class MassConverter extends Converter {

  /**
   * Constructor used for instantiation.
   * @param massUnitOfMeasure @{@link MassUnitOfMeasure}
   */
  public MassConverter(MassUnitOfMeasure massUnitOfMeasure) {

    super(massUnitOfMeasure);
  }

}
