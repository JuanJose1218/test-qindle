package com.qindel.test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PricesDto {


  @JsonIgnore
  private Integer id;



  private Integer brandId;


  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime startDate;


  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime endDate;

  @JsonIgnore
  private Long priceList;


  private Integer productId;


  @JsonIgnore
  private Long priority;


  private BigDecimal price;

  @JsonIgnore
  private String currency;

}
