package com.example.agrimarket;

import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    private BuyerRepository buyerRepo;

    public BuyerService(BuyerRepository buyerRepo) {
        this.buyerRepo = buyerRepo;
    }

    // SIGNUP
    public String signup(Buyer buyer) {

        // Check username already exists
        if (buyerRepo.findByUsername(buyer.getUsername()) != null) {
            return "Username already exists";
        }

        // Default wallet = 0
        buyer.setWallet(0);

        buyerRepo.save(buyer);

        return "Buyer signup successful";
    }

    
    // LOGIN
    public Buyer login(LoginRequest request) {

        Buyer buyer = buyerRepo.findByUsername(request.getUsername());

        if (buyer != null && buyer.getPassword().equals(request.getPassword())) {
            return buyer;
        }

        return null;
    }

    
//    // WALLET RECHARGE
    public String rechargeWallet(int buyerId, int amount) {

        Buyer buyer = buyerRepo.findById(buyerId).orElse(null);

        if (buyer == null) {
            return "Buyer not found";
        }

        if (amount <= 0) {
            return "Invalid recharge amount";
        }

        buyer.setWallet(buyer.getWallet() + amount);

        buyerRepo.save(buyer);

        return "Wallet recharged successfully";
    }

    
    // GET BUYER BY ID
    public Buyer getBuyerById(int id) {
        return buyerRepo.findById(id).orElse(null);
    }
    
}