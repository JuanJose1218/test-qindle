package com.qindel.test.controller;

import com.qindel.test.dto.PricesDto;
import com.qindel.test.service.TestQindelService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/e-commerce")
public class TestQindelController {

  @Autowired
  TestQindelService service;


  @GetMapping(value = "/prices/{date}/{productId}/{brandId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = PricesDto.class, responseContainer = "List")})
  public ResponseEntity<Object> getPrices(
    @Valid
    @ApiParam(name = "date", type = "String", value = "fecha inicio de precio", example = "2020-06-14T16:00:00", required = true)
    @PathVariable String date,
    @Valid
    @ApiParam(name = "productId", type = "number", value = "id de producto", example = "35455", required = true)
    @PathVariable Integer productId,
    @Valid
    @ApiParam(name = "brandId", type = "number", value = "id de cadena", example = "2020-06-15T21:00:00", required = true)
    @PathVariable Integer brandId) {
    return ResponseEntity.ok(service.getPricesByDate(date, productId, brandId));
  }


}
