package com.dariojolo.zaratest.app.services;

import com.dariojolo.zaratest.app.entities.Price;
import com.dariojolo.zaratest.app.entities.PriceDTO;
import com.dariojolo.zaratest.app.repositories.IPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PriceServiceImpl implements IPriceService {


    private final IPriceRepository repository;

    @Autowired
    public PriceServiceImpl(IPriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PriceDTO> findByProductId(String productId, int brandId, LocalDateTime date) {
        Stream<Price> prices = repository.findByProductId(productId).stream().flatMap(l -> l.stream());
        List<PriceDTO> returnList = new ArrayList<>();
        prices
                .filter(p -> p.getBrandId() == brandId && p.getStartDate().isBefore(date) && p.getEndDate().isAfter(date))
                .collect(Collectors.toList())
                .forEach(d -> returnList.add(PriceDTO.builder()
                        .productId(d.getProductId())
                        .brandId(d.getBrandId())
                        .priceList(d.getPriceList())
                        .startDate(d.getStartDate())
                        .endDate(d.getEndDate())
                        .price(d.getPrice())
                        .build()));
        return returnList;
    }
}
