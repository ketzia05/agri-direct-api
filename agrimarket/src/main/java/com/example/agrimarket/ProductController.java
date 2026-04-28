package com.example.agrimarket;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // 🔥 UPDATED
    @PostMapping("/products")
    public String addProduct(@RequestBody Product p,
                             @RequestParam int farmerId) {
        return service.addProduct(p, farmerId);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }
    
    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable int id,
                                @RequestBody UpdateProductRequest req) {

        return service.updateProductDetails(id, req);
    }
    
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}