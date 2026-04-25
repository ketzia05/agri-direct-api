package com.example.agrimarket;

public class PurchaseRequest {

    private int productId;
    private int buyerId;
    private int qty;

    public PurchaseRequest() {}  // important

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getBuyerId() { return buyerId; }
    public void setBuyerId(int buyerId) { this.buyerId = buyerId; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }
}