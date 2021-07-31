package com.dariojolo.zaratest.app.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "prices")
public class Price{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="brand_id")
    private int brandId;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column(name="end_date")
    private LocalDateTime endDate;

    @Column(name="price_list")
    private String priceList;

    @Column(name="product_id")
    private String productId;

    private int priority;

    private Double price;

    @Column(name="curr")
    private String currency;
}
