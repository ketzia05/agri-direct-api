package com.example.agrimarket;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {

    private ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public String addProduct(Product p) {

        if(p.getName() == null || p.getName().isEmpty()) {
            return "Product name cannot be empty";
        }

        if(p.getPrice() <= 0) {
            return "Price must be greater than 0";
        }

        if(p.getQty() <= 0) {
            return "Quantity must be greater than 0";
        }

        if(repo.findByName(p.getName()) != null) {
            return "Product already exists";
        }

        repo.save(p);
        return "Product added successfully";
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public String deleteProduct(String name) {

        Product p = repo.findByName(name);

        if(p == null) {
            return "Product not found";
        }

        repo.delete(p);
        return "Product deleted successfully";
    }

    public String updateQuantity(String name, int qty) {

        Product p = repo.findByName(name);

        if(p == null) {
            return "Product not found";
        }

        if(qty <= 0) {
            return "Quantity must be greater than 0";
        }

        if(p.getQty() < qty) {
            return "Insufficient stock";
        }

        p.setQty(p.getQty() - qty);
        repo.save(p);

        return "Updated successfully. Remaining: " + p.getQty();
    }
}