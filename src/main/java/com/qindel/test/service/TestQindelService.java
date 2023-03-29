package com.qindel.test.service;

import com.qindel.test.dto.PricesDto;



public interface TestQindelService {
  PricesDto getPricesByDate(String date, Integer productId, Integer brandId);
}
