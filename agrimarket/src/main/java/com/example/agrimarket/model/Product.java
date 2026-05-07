package com.example.agrimarket.model;

import jakarta.persistence.*;

@Entity
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int price;

    private int costPrice;

    private int qty;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;
    

    public Product() {}

    public Product(String name, int price, int costPrice, int qty) {
        this.name = name;
        this.price = price;
        this.costPrice = costPrice;
        this.qty = qty;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getQty() { return qty; }
    public Farmer getFarmer() { return farmer; }
    public int getCostPrice() { return costPrice; }

    public void setName(String name) { this.name = name; }
    public void setPrice(int price) { this.price = price; }
    public void setQty(int qty) { this.qty = qty; }
    public void setFarmer(Farmer farmer) { this.farmer = farmer; }
    public void setCostPrice(int cp) { this.costPrice = cp; }
}