package com.example.agrimarket;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private TransactionRepository repo;

    public TransactionController(TransactionRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return repo.findAll();
    }
    
    @GetMapping("/transactions/buyer/{id}")
    public List<Transaction> getBuyerHistory(@PathVariable int id) {
        return repo.findByBuyerId(id);
    }

    @GetMapping("/transactions/farmer/{id}")
    public List<Transaction> getFarmerHistory(@PathVariable int id) {
        return repo.findByFarmerId(id);
    }
}
