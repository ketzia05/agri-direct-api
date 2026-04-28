package com.example.agrimarket;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {

    private ProductRepository repo;
    private FarmerRepository farmerRepo; // 🔥 NEW
    

    public ProductService(ProductRepository repo, FarmerRepository farmerRepo) {
        this.repo = repo;
        this.farmerRepo = farmerRepo;
    }

    // 🔥 UPDATED METHOD
    public String addProduct(Product p, int farmerId) {

        if(p.getName() == null || p.getName().isEmpty()) {
            return "Product name cannot be empty";
        }

        if(p.getPrice() <= 0) {
            return "Price must be greater than 0";
        }

        if(p.getQty() <= 0) {
            return "Quantity must be greater than 0";
        }

        // 🔥 Get farmer
        Farmer farmer = farmerRepo.findById(farmerId).orElse(null);

        if(farmer == null) {
            return "Farmer not found";
        }

        // 🔥 Link product → farmer
        p.setFarmer(farmer);

        repo.save(p);

        return "Product added successfully";
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }
    
    public String updateProductDetails(int id, UpdateProductRequest req) {

        Product p = repo.findById(id).orElse(null);

        if (p == null) {
            return "Product not found";
        }

        if (req.getQty() != null) {
            if (req.getQty() < 0) return "Quantity cannot be negative";
            p.setQty(req.getQty());
        }

        if (req.getPrice() != null) {
            if (req.getPrice() <= 0) return "Price must be greater than zero";
            p.setPrice(req.getPrice());
        }

        repo.save(p);

        return "Product updated successfully";
    }
    
    public String deleteProduct(int id) {

        Product p = repo.findById(id).orElse(null);

        if (p == null) {
            return "Product not found";
        }

        repo.delete(p);

        return "Product deleted successfully";
    }
}