package com.prueba.altia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * bean product
 */
@Data
@AllArgsConstructor
public class Product {

  private String productId;
  private String brandId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private java.math.BigDecimal price;
  private String rate;

}

