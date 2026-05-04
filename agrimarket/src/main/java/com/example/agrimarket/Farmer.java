package com.example.agrimarket;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

 // 🔥 NEW: Relationship
    @OneToMany(mappedBy = "farmer")
    @JsonIgnore
    private List<Product> products;
    
    private String name;
    private String location;
    private String username;
	private String password;
	private Integer wallet;

    public Farmer() {}

    public Farmer(String name, String username, String password, Integer wallet, String location) {
        this.name = name;
        this.location = location;
        this.password = password;
        this.username = username;
        this.wallet = wallet;
        
    }

    public int getId() { return id; }
    
    public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	
	public void setUsername(String username) { this.username = username; }
	public String getUsername() { return username; }
	
	public void setPassword(String password) { this.password = password; }
	public String getPassword() { return password; }
	
	public void setLocation(String location) { this.location = location; }
	public String getLocation() { return location; }
	
	public void setWallet(Integer wallet) { this.wallet = wallet; }
	public Integer getWallet() { return wallet; }
	
	public List<Product> getProducts() { return products; }
	public void setProducts(List<Product> products) { this.products = products; }
}