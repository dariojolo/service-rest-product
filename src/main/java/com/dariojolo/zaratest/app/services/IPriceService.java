package com.dariojolo.zaratest.app.services;

import com.dariojolo.zaratest.app.Entities.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface IPriceService {
    List<Price> findByProductId(String productId, int brandId, LocalDateTime date);
}
