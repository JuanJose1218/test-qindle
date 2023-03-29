package com.qindel.test.service.impl;

import com.qindel.test.dto.PricesDto;
import com.qindel.test.exception.PricesException;
import com.qindel.test.repository.PriceRepository;
import com.qindel.test.service.TestQindelService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TestQindelServiceImpl implements TestQindelService {
  @Autowired
  PriceRepository priceRepository;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public PricesDto getPricesByDate(String date, Integer productId, Integer brandId) {
    log.info("date {} ", date);
    return priceRepository.findByDateAndProductIdAndBrandId(LocalDateTime.parse(date), productId, brandId).
      orElseThrow(() -> new PricesException("error when obtain prices"))
      .stream().map(i -> modelMapper.map(i, PricesDto.class))
      .collect(Collectors.toList()).get(0);


  }
}
