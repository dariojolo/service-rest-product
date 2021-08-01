package com.dariojolo.zaratest.app.services;

import com.dariojolo.zaratest.app.Entities.Price;
import com.dariojolo.zaratest.app.repositories.IPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements IPriceService {


    private final IPriceRepository repository;

    @Autowired
    public PriceServiceImpl(IPriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Price> findByProductId(String productId, int brandId, LocalDateTime date) {
        return repository.findByProductId(productId)
                .stream()
                .filter(p -> p.getBrandId() == brandId && p.getStartDate().isBefore(date) && p.getEndDate().isAfter(date))
                .collect(Collectors.toList());
    }
}
