package com.unit.converter.converter.rest;

import com.unit.converter.ConverterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConverterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConverterRestServiceTest {

  @LocalServerPort
  private int port;

  TestRestTemplate restTemplate = new TestRestTemplate();

  HttpHeaders headers = new HttpHeaders();

  @Test
  public void convertMass() {

    headers.add("Content-Type", "application/json");
    headers.add("Accept", "application/json");

    ConverterResource resource = buildResource(10.0, "G", "KG");

    HttpEntity<ConverterResource> entity = new HttpEntity<ConverterResource>(resource, headers);

    ResponseEntity<ConverterResource> response = restTemplate.exchange(
            getURI() +  "/mass",
            HttpMethod.POST, entity, ConverterResource.class);

    Double result = response.getBody().getResult();
    assertNotNull(result);

  }

  @Test
  public void convertLength() {

    headers.add("Content-Type", "application/json");
    headers.add("Accept", "application/json");

    ConverterResource resource = buildResource(10.0, "M", "CM");

    HttpEntity<ConverterResource> entity = new HttpEntity<ConverterResource>(resource, headers);

    ResponseEntity<ConverterResource> response = restTemplate.exchange(
            getURI() +  "/length",
            HttpMethod.POST, entity, ConverterResource.class);

    Double result = response.getBody().getResult();
    assertNotNull(result);

  }

  @Test
  public void convertTemperature() {

    headers.add("Content-Type", "application/json");
    headers.add("Accept", "application/json");

    ConverterResource resource = buildResource(10.0, "CELSIUS", "CELSIUS");

    HttpEntity<ConverterResource> entity = new HttpEntity<ConverterResource>(resource, headers);

    ResponseEntity<ConverterResource> response = restTemplate.exchange(
            getURI() +  "/temperature",
            HttpMethod.POST, entity, ConverterResource.class);

    Double result = response.getBody().getResult();
    assertNotNull(result);

  }

  /**
   * Builds a resource to POST with the REST call.
   * @param value the value
   * @param fromUnit the fromUnit
   * @param toUnit to toUnit
   * @return @{@link ConverterResource}
   */
  private ConverterResource buildResource(Double value, String fromUnit, String toUnit) {
    ConverterResource resource = new ConverterResource();
    resource.setValue(value);
    resource.setFromUnit(fromUnit);
    resource.setToUnit(toUnit);
    return resource;
  }

  /**
   * Retrieves REST uri.
   * @return @{@link String}
   */
  private String getURI() {
    return "http://localhost:" + port + "/converter";
  }
}
