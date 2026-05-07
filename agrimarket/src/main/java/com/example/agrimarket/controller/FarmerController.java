package com.example.agrimarket.controller;

import org.springframework.web.bind.annotation.*;

import com.example.agrimarket.dto.LoginRequest;
import com.example.agrimarket.model.Farmer;
import com.example.agrimarket.service.FarmerService;

@RestController
@CrossOrigin("*")
public class FarmerController {

    private FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    // SIGNUP
    @PostMapping("/farmer")
    public String addFarmer(@RequestBody Farmer farmer) {

        return farmerService.signup(farmer);
    }

    // LOGIN
    @PostMapping("/farmer/login")
    public Farmer login(@RequestBody LoginRequest request) {
        return farmerService.login(request);
    }
    
    @GetMapping("/farmer/{id}")
    public Farmer getFarmerById(@PathVariable int id) {
        return farmerService.getFarmerById(id);
    }
}