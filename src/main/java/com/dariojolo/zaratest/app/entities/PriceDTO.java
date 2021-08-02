package com.dariojolo.zaratest.app.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO {
    private String productId;
    private int brandId;
    private String priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
}
