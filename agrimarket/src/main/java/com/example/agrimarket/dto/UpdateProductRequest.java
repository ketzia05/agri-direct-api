package com.example.agrimarket.dto;

public class UpdateProductRequest {
	private Integer qty;
    private Integer price;

    public UpdateProductRequest() {}
    
    public Integer getQty() { return qty; }
    public Integer getPrice() { return price; }
}
