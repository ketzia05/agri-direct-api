package com.example.agrimarket;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {

    private ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    //Validations of add product
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
        if(getProductIfExists(p.getName())) {
            return "Product already exists";
        }

        repo.save(p);
        return "Product added successfully";
    }

    //Get all the products from repository
    public List<Product> getProducts() {
        return repo.findAll();
    }
    
    //Get particular product from repository
    public String findPro(String name) {
    		return repo.findByName(name).getName()+" - ₹"+repo.findByName(name).getPrice()+" Qty: "+repo.findByName(name).getQty();
    }
    
    public String delPro(String name) {
    		if(!getProductIfExists(name)) return "Product Not found";
    		repo.deleteProduct(name);
    		return "Product Deleted";
    }
    
    public String updatePro(String name, int qty) {
    		if(!getProductIfExists(name)) return "Product Not found";
    		if(repo.updateQuantity(name, qty)) {
    			return "Product Updated Successfully";
    		}
    		return "Insufficient stocks";
    }
    
    //Check if the product is already exists
    public boolean getProductIfExists(String name) {
        return repo.findByName(name) != null;
    }
}
