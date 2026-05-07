package com.example.agrimarket.controller;

import org.springframework.web.bind.annotation.*;

import com.example.agrimarket.dto.PurchaseRequest;
import com.example.agrimarket.service.PurchaseService;

@RestController
public class PurchaseController {

    private PurchaseService service;

    public PurchaseController(PurchaseService service) {
        this.service = service;
    }
    
    @PostMapping("/purchase")
    public String purchase(@RequestBody PurchaseRequest req) {
        return service.purchase(
            req.getProductId(),
            req.getBuyerId(),
            req.getQty()
        );
    }
}
