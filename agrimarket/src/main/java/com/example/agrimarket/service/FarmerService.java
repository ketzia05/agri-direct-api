package com.example.agrimarket.service;

import org.springframework.stereotype.Service;

import com.example.agrimarket.dto.LoginRequest;
import com.example.agrimarket.model.Farmer;
import com.example.agrimarket.repository.FarmerRepository;

@Service
public class FarmerService {

    private FarmerRepository repo;

    public FarmerService(FarmerRepository farmerRepo) {
        this.repo = farmerRepo;
    }

    // SIGNUP
    public String signup(Farmer f) {

        if(repo.findByUsername(f.getUsername()) != null) {
            return "Username already exists";
        }

        repo.save(f);
        return "Farmer signup successful";
    }

    // LOGIN
    public Farmer login(LoginRequest request) {

        Farmer farmer = repo.findByUsername(request.getUsername());

        if (farmer != null && farmer.getPassword().equals(request.getPassword())) {
            return farmer;
        }

        return null;
    }
    
    public Farmer getFarmerById(int id) {
        return repo.findById(id).orElse(null);
    }
}