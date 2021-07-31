package com.dariojolo.zaratest.app.repositories;


import com.dariojolo.zaratest.app.Entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByProductId(String productId);
}
