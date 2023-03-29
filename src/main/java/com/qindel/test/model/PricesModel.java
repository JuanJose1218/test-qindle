package com.qindel.test.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "prices")
@Entity
@Data
public class PricesModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "brand_id")
  private Integer brandId;


  @Column(name = "start_date")
  private LocalDateTime startDate;

  @Column(name = "end_date")
  private LocalDateTime endDate;

  @Column(name = "price_list")
  private Long priceList;

  @Column(name = "product_id")
  private Integer productId;

  @Column(name = "priority")
  private Long priority;


  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "curr")
  private String currency;

}
