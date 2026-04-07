package coreJavaVersion;

import java.util.*;

class Farmer extends User {
    public Farmer(int id, String name) {
		super(id, name, "Farmer");
		System.out.println("Farmer Created: "+ name+" "+"(ID: "+id+")");
	}

	private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added by " + this.getName() + ": "
            + p.getName() + " - ₹" + p.getPrice() + " - Qty: " + p.getQuantity());
    }

    public List<Product> getProducts() {
        return products;
    }
}