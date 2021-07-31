package com.dariojolo.zaratest.app.Controllers;

import com.dariojolo.zaratest.app.Entities.Price;
import com.dariojolo.zaratest.app.services.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/prices")
public class PriceController {

    @Autowired
    private PriceServiceImpl service;

    @GetMapping("/product/{productId}/brand/{brandId}/date/{date}")
    public ResponseEntity<List<Price>> getPrices(@PathVariable(name = "productId") String productId,
                                                 @PathVariable(name = "brandId") int brandId,
                                                 @PathVariable(name = "date") LocalDateTime date) {
        List<Price> listPrices = new ArrayList<>();
        listPrices = service.findByProductId(productId, brandId, date);
        if (listPrices.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listPrices);
    }
}
