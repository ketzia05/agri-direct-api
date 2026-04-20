package com.example.agrimarket;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class FarmerController {

	private FarmerService service;
	
	public FarmerController(FarmerService service) {
		this.service = service;
	}
	
	@PostMapping("/farmers")
	public String addFar(@RequestBody Farmer f) {
		return service.addFarmer(f);
	}
	
	@GetMapping("/farmers")
	public List<Farmer> getFar(){
		return service.getFarmers();
	}
	
	@DeleteMapping("/farmers/delete/{name}")
	public String delF(@PathVariable String name) {
		return service.deleteFarmer(name);
	}
}
