package com.unit.converter.unitofmeasure.rest;

import com.unit.converter.unitofmeasure.LengthUnitOfMeasure;
import com.unit.converter.unitofmeasure.MassUnitOfMeasure;
import com.unit.converter.unitofmeasure.TemperatureUnitOfMeasure;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Unit of Measure Rest Service.
 */
@Path("/unit")
public class UnitOfMeasureRestService {

  private TemperatureUnitOfMeasure temperatureUnitOfMeasure;
  private MassUnitOfMeasure massUnitOfMeasure;
  private LengthUnitOfMeasure lengthUnitOfMeasure;

  /**
   * Constructor for implementing a Unit Ofg Measure Rest Service Instance.
   *
   * @param temperatureUnitOfMeasure @{@link TemperatureUnitOfMeasure}
   * @param massUnitOfMeasure @{@link MassUnitOfMeasure}
   * @param lengthUnitOfMeasure @{@link LengthUnitOfMeasure}
   */
  @Autowired
  public UnitOfMeasureRestService(TemperatureUnitOfMeasure temperatureUnitOfMeasure,
                                  MassUnitOfMeasure massUnitOfMeasure,
                                  LengthUnitOfMeasure lengthUnitOfMeasure) {
    this.temperatureUnitOfMeasure = temperatureUnitOfMeasure;
    this.massUnitOfMeasure = massUnitOfMeasure;
    this.lengthUnitOfMeasure = lengthUnitOfMeasure;
  }

  /**
   * Retrieves a list of Temperature Units.
   * @return @{@link List} of {@link TemperatureUnitOfMeasure}
   */
  @GET
  @Path("/temperature")
  @Produces(MediaType.APPLICATION_JSON)
  public List<UnitOfMeasureResource> getTemperatureUnits(@Context HttpServletResponse response) {
    return temperatureUnitOfMeasure.getUnitOfMeasureResourceList();
  }

  /**
   * Retrieves a list of Mass Units.
   * @return @{@link List} of {@link MassUnitOfMeasure}
   */
  @GET
  @Path("/mass")
  @Produces(MediaType.APPLICATION_JSON)
  public List<UnitOfMeasureResource> getMassUnits() {
    return massUnitOfMeasure.getUnitOfMeasureResourceList();
  }

  /**
   * Retrieves a list of Length Units.
   * @return @{@link List} of {@link UnitOfMeasureResource}
   */
  @GET
  @Path("/length")
  @Produces(MediaType.APPLICATION_JSON)
  public List<UnitOfMeasureResource> getLengthUnits() {
    return lengthUnitOfMeasure.getUnitOfMeasureResourceList();
  }
}
