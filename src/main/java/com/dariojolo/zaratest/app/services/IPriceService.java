package com.dariojolo.zaratest.app.services;

import com.dariojolo.zaratest.app.Entities.PriceDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IPriceService {
    List<PriceDTO> findByProductId(String productId, int brandId, LocalDateTime date);
}
