package com.example.agrimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agrimarket.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);
    
}