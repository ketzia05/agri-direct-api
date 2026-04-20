package com.example.agrimarket;

import jakarta.persistence.*;

@Entity
public class Farmer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String location;
	
	public Farmer() {}
	
	public Farmer(String name, String location) {
		this.name = name;
		this.location = location;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String loc) {
		this.location = loc;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
