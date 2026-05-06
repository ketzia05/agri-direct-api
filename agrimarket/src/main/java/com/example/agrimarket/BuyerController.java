package com.example.agrimarket;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class BuyerController {

    private BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    // SIGNUP
    @PostMapping("/buyer")
    public String signup(@RequestBody Buyer buyer) {
        return buyerService.signup(buyer);
    }

 // LOGIN
    @PostMapping("/buyer/login")
    public Buyer login(@RequestBody LoginRequest request) {
        return buyerService.login(request);
    }

// WALLET RECHARGE
    @PutMapping("/buyer/recharge/{id}")
    public String rechargeWallet(@PathVariable int id,
                                 @RequestBody RechargeRequest request) {

        return buyerService.rechargeWallet(id, request.getAmount());
    }

    // GET BUYER DETAILS
    @GetMapping("/buyer/{id}")
    public Buyer getBuyer(@PathVariable int id) {
        return buyerService.getBuyerById(id);
    }
}