package com.example.agrimarket;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public void save(Product p) {
        products.add(p);
    }

    public List<Product> findAll() {
        return products;
    }
    
    public Product findByName(String name) {
    		for(Product p : products) {
    			if(p.getName().equalsIgnoreCase(name)) {
    				return p;
    			}
    		}
    		return null;
    }
    
    public boolean deleteProduct(String name) {
    		return products.removeIf(s -> s.getName().equalsIgnoreCase(name));
    }
    
    public boolean updateQuantity(String name, int qty) {
	    	for(Product p : products) {
			if(p.getName().equalsIgnoreCase(name)) {
				if(p.getQty() >= qty) {
					p.setQty(p.getQty() - qty);
					return true;
				}
				else {
					return false;
				}
			}
		}
	    	return false;
    }
}
