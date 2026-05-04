package com.example.agrimarket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {

    Farmer findByUsername(String username);

}