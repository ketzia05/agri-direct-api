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
}
