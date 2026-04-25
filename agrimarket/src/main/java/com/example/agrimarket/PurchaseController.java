package com.example.agrimarket;

import org.springframework.web.bind.annotation.*;

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
