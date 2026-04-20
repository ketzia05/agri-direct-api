package com.example.agrimarket;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FarmerService {
	private FarmerRepository repo;
	
	public FarmerService(FarmerRepository repo) {
		this.repo = repo;
	}
	
	public String addFarmer(Farmer f) {
		if(f.getName() == null || f.getName().isEmpty()) {
			return "Farmer Name cannot be empty";
		}
		
		if(repo.findByName(f.getName()) != null) {
			return "Duplicate Farmer";
		}
		repo.save(f);
		return "Farmer added successfully";
	}
	
	public List<Farmer> getFarmers(){
		return repo.findAll();
	}
	
	public String deleteFarmer(String name) {
		Farmer b = repo.findByName(name);
		if(repo.findByName(name) == null) {
			return "Farmer Not exists";
		}
		repo.delete(b);
		return "Farmer Deleted Successfully";
	}
}
