package com.dariojolo.zaratest.app.controllers;

import com.dariojolo.zaratest.app.Controllers.PriceController;
import com.dariojolo.zaratest.app.Entities.PriceDTO;
import com.dariojolo.zaratest.app.services.PriceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceController.class)
public class PriceControllerTest {

    @MockBean
    private PriceServiceImpl service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateMockmvc() {
        Assertions.assertNotNull(mockMvc);
    }

    @Test
    void testGetProduct() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 15, 16, 00, 01);

        Mockito.when(service.findByProductId("35455", 1, LocalDateTime.parse("2020-06-15T16:00:00")))
                .thenReturn(List.of(PriceDTO.builder()
                        .productId("35455")
                        .brandId(1)
                        .priceList("4")
                        .startDate(date)
                        .endDate(date)
                        .price(38.95)
                        .build()));

        this.mockMvc.perform(get("/api/v1/prices/product/{productId}/brand/{brandId}/date/{date}", "35455", 1, "2020-06-15 16:00:00"))
                .andExpect(status().isOk());
    }
}
