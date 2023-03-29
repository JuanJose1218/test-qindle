package com.qindel.test.repository;

import com.qindel.test.model.PricesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<PricesModel, Integer> {


  @Query(value = "select * from prices where :date>=start_date and :date<=end_date  and product_id=:productId and brand_id =:brandId order by priority desc", nativeQuery = true)
  Optional<List<PricesModel>> findByDateAndProductIdAndBrandId(LocalDateTime date, Integer productId, Integer brandId);
}
