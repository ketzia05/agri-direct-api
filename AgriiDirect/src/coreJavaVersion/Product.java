package coreJavaVersion;

public class Product{
	private int id;
	private String name;
	private int price;
	private int quantity;
	
	public Product(int id, String name, int price, int q) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = q;
	}
	
	public void setPrice(int p) {
		this.price = p;
	}
	
	public void setQuantity(int q) {
		this.quantity = q;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void reduceQuantity(int qty) {
	    if(qty <= this.quantity) {
	        this.quantity -= qty;
	    }
	}
}

