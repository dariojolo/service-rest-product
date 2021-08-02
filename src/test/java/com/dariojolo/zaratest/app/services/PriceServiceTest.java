package com.dariojolo.zaratest.app.services;

import com.dariojolo.zaratest.app.entities.Price;
import com.dariojolo.zaratest.app.entities.PriceDTO;
import com.dariojolo.zaratest.app.repositories.IPriceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PriceServiceTest {

    @Mock
    private IPriceRepository repository;
    private IPriceService service;

    LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 15, 16, 00, 01);

    @BeforeEach
    public void setup() {
        service = new PriceServiceImpl(repository);

        Optional<List<Price>> listado = Optional.of(List.of(Price.builder().productId("35455").startDate(date).endDate(date).brandId(1).build(),
                Price.builder().productId("35455").startDate(date).endDate(date).brandId(1).build()));
        Mockito.when(repository.findByProductId("35455"))
                .thenReturn(listado);
    }

    @Test
    public void whenFindProductByID_ThenReturnPricesList() {
        List<PriceDTO> listadoRetornado = service.findByProductId("35455", 1, date);
        Assertions.assertThat(listadoRetornado.stream().toList().size() == 2);
    }
}
