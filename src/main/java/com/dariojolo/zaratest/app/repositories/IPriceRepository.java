package com.dariojolo.zaratest.app.repositories;


import com.dariojolo.zaratest.app.Entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPriceRepository extends JpaRepository<Price, Long> {
    Optional<List<Price>> findByProductId(String productId);
}
