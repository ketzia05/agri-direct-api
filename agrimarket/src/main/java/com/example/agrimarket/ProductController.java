package com.example.agrimarket;
import java.util.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {
	private ProductService service;

	public ProductController(ProductService service) {
	    this.service = service;
	}
	
	//post the products
	@PostMapping("/products")
	public String addProduct(@RequestBody Product p) {
	    return service.addProduct(p);
	}
	
	//Fetch the products
	@GetMapping("/products")
	public List<Product> getProducts() {
	    return service.getProducts();
	}
	
	
	//Update the quantity of the product
	@PutMapping("/products/update/{name}")
	public String updateQty(@PathVariable String name,
	                        @RequestParam int qty) {
	    return service.updateQuantity(name, qty);
	}
	
	//Delete a product
	@DeleteMapping("/products/delete/{name}")
	public String delProduct(@PathVariable String name) {
	    return service.deleteProduct(name);
	}
}
