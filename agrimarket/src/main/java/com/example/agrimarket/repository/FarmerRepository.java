package com.example.agrimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agrimarket.model.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {

    Farmer findByUsername(String username);

}