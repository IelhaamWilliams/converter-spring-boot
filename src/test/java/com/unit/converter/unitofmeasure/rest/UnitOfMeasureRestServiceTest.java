package com.unit.converter.unitofmeasure.rest;

import com.unit.converter.ConverterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConverterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UnitOfMeasureRestServiceTest {

  @LocalServerPort
  private int port;

  TestRestTemplate restTemplate = new TestRestTemplate();

  HttpHeaders headers = new HttpHeaders();

  @Test
  public void testGetTemperatureUnits() {
    HttpEntity<List> entity = new HttpEntity<List>(null, headers);

    ResponseEntity<List> response = restTemplate.exchange(
            getURI()+"/temperature",
            HttpMethod.GET, entity, List.class);

    assertEquals(2, response.getBody().size());
  }

  @Test
  public void testGetMassUnits() {
    HttpEntity<List> entity = new HttpEntity<List>(null, headers);

    ResponseEntity<List> response = restTemplate.exchange(
            getURI()+"/mass",
            HttpMethod.GET, entity, List.class);

    assertEquals(4, response.getBody().size());
  }

  @Test
  public void testGetLengthUnits() {
    HttpEntity<List> entity = new HttpEntity<List>(null, headers);

    ResponseEntity<List> response = restTemplate.exchange(
            getURI()+"/length",
            HttpMethod.GET, entity, List.class);

    assertEquals(8, response.getBody().size());
  }

  /**
   * Retrieves REST uri.
   * @return @{@link String}
   */
  private String getURI() {
    return "http://localhost:" + port + "/unit";
  }
}
