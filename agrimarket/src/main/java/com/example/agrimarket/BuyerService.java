package com.example.agrimarket;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BuyerService {
	
	private BuyerRepository repo;
	
	public BuyerService(BuyerRepository repo) {
		this.repo = repo;
	}
	
	public String addBuyer(Buyer b) {
		if(b.getName()==null || b.getName().isEmpty()) {
			return "Buyer name should not be empty";
		}
		
		if(repo.findByName(b.getName()) != null){
			return "Duplicate Buyer";
		}
		
		if(b.getBal() <= 0) {
			return "Balance cannot be zero";
		}
		
		repo.save(b);
		return "Buyer added Successfully";
	}
	
	public List<Buyer> getBuyer(){
		return repo.findAll();
	}
	
	public String deleteBuyer(String name) {
		Buyer b = repo.findByName(name);
		if(repo.findByName(name) == null) {
			return "Buyer Not exists";
		}
		repo.delete(b);
		return "Buyer Deleted Successfully";
	}
	
	
}
