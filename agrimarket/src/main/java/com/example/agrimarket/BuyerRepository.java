package com.example.agrimarket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

	Buyer findByUsername(String username);
}