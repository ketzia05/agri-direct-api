package com.example.agrimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agrimarket.model.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

	Buyer findByUsername(String username);
}