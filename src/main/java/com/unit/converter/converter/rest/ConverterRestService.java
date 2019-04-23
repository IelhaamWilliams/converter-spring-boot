package com.unit.converter.converter.rest;

import com.unit.converter.converter.LengthConverter;
import com.unit.converter.converter.MassConverter;
import com.unit.converter.converter.TemperatureConverter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Converter REST service Implementation.
 */
@Path("/converter")
public class ConverterRestService
{
  private TemperatureConverter temperatureConverter;
  private MassConverter massConverter;
  private LengthConverter lengthConverter;

  /**
   *
   * @param temperatureConverter
   */
  @Autowired
  public ConverterRestService(TemperatureConverter temperatureConverter,
                              MassConverter massConverter,
                              LengthConverter lengthConverter) {
    this.temperatureConverter = temperatureConverter;
    this.massConverter = massConverter;
    this.lengthConverter = lengthConverter;
  }

  /**
   * Converts Temperature from Imperial to Metric, Metric to Imperial,
   * Imperial to Imperial or Metric to Metric.
   * @param @{@link ConverterResource}
   * @return @{@link ConverterResource}
   */
  @POST
  @Path("/temperature")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ConverterResource convertTemperature(ConverterResource resource) throws  Exception {
    try
    {
      return new ConverterResource(resource.getFromUnit(),
              resource.getToUnit(),
              temperatureConverter.convert(resource.getValue(),
                      resource.getFromUnit(), resource.getToUnit()));
    } catch(Exception e) {
      throw e;
    }
  }

  /**
   * Converts Mass from Imperial to Metric, Metric to Imperial,
   * Imperial to Imperial or Metric to Metric.
   * @param @{@link ConverterResource}
   * @return @{@link ConverterResource}
   */
  @POST
  @Path("/mass")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ConverterResource convertMass(ConverterResource resource) throws Exception{
    try
    {
      return new ConverterResource(resource.getFromUnit(),
              resource.getToUnit(),
              massConverter.convert(resource.getValue(),
                      resource.getFromUnit(), resource.getToUnit()));
    }catch (Exception e) {
      throw e;
    }
  }

  /**
   * Converts Length from Imperial to Metric, Metric to Imperial,
   * Imperial to Imperial or Metric to Metric.
   * @param @{@link ConverterResource}
   * @return @{@link ConverterResource}
   */
  @POST
  @Path("/length")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public ConverterResource convertLength(ConverterResource resource) throws Exception {
    try
    {
      return new ConverterResource(resource.getFromUnit(),
              resource.getToUnit(),
              lengthConverter.convert(resource.getValue(),
                      resource.getFromUnit(), resource.getToUnit()));
    } catch (Exception e) {
      throw e;
    }
  }
}
