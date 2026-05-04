package com.example.agrimarket;

import jakarta.persistence.*;

@Entity
public class Buyer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String username;
	private String password;
	private Integer wallet;
	
	public Buyer() {}
	
	public Buyer(String name, String username, String password, Integer wallet) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.wallet = wallet;
	}
	
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	
	public void setUsername(String username) { this.username = username; }
	public String getUsername() { return username; }
	
	public void setPassword(String password) { this.password = password; }
	public String getPassword() { return password; }
	
	public void setWallet(Integer wallet) { this.wallet = wallet; }
	public Integer getWallet() { return wallet; }

	public int getId() { return id; }
}
