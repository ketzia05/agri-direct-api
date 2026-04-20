package com.example.agrimarket;

import jakarta.persistence.*;

@Entity
public class Buyer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private Integer bal;
	
	public Buyer() {}
	
	public Buyer(String name, Integer bal) {
		this.name = name;
		this.bal = bal;
	}
	
	public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBal() {
        return bal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBal(Integer bal) {
        this.bal = bal;
    }
	
}
