package com.example.agrimarket;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class BuyerController {
	
	private BuyerService service;
	
	public BuyerController(BuyerService service) {
		this.service = service;
	}
	
	@PostMapping("/buyer")
	public String addB(@RequestBody Buyer b) {
		return service.addBuyer(b);
	}
	
	@GetMapping("/buyer")
	public List<Buyer> getB(){
		return service.getBuyer();
	}
	
	@DeleteMapping("/buyer/delete/{name}")
	public String delB(@PathVariable String name) {
		return service.deleteBuyer(name);
	}
	
}
