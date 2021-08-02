package com.dariojolo.zaratest.app.repositories;

import com.dariojolo.zaratest.app.Entities.Price;
import com.dariojolo.zaratest.app.Entities.PriceDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DataJpaTest
public class PriceRepositoryTest {

    @Autowired
    private IPriceRepository repository;

    @Test
    public void whenFindByProductId_thenReturnProductsList() {
        Stream<Price> prices = repository.findByProductId("35455").stream().flatMap(l -> l.stream());
        List<PriceDTO> testList = new ArrayList<>();
        prices
                .collect(Collectors.toList())
                .forEach(d -> testList.add(PriceDTO.builder()
                        .productId(d.getProductId())
                        .brandId(d.getBrandId())
                        .priceList(d.getPriceList())
                        .startDate(d.getStartDate())
                        .endDate(d.getEndDate())
                        .price(d.getPrice())
                        .build()));
        Assertions.assertThat(testList.size() > 0);
        Assertions.assertThat(testList.get(0).getBrandId() == 1);

    }
}
