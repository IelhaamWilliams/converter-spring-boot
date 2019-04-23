package com.unit.converter;

import com.unit.converter.converter.rest.ConverterRestService;
import com.unit.converter.unitofmeasure.rest.UnitOfMeasureRestService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class ApplicationServerConfig extends ResourceConfig
{
  public ApplicationServerConfig() {
    register(ConverterRestService.class);
    register(UnitOfMeasureRestService.class);
  }
}