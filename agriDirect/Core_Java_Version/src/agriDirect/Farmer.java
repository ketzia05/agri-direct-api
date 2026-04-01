package agriDirect;

import java.util.ArrayList;

class Farmer extends User {
	ArrayList<Product> products = new ArrayList<>();
	
    public Farmer(int id, String name) {
        super(id, name, "Farmer");
        System.out.println("Farmer created: " + name + " (ID: " + id + ")");
    }
    
    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added by " + this.name + ": "
            + p.getName() + " - ₹" + p.getPrice() + " - Quantity: " + p.getQuantity());
    }
    
    public void showProducts() {
        System.out.println("Available Products:");
        for(Product p : products) {
            System.out.println(p.getName() + " - ₹" + p.getPrice() + " - Qty: " + p.getQuantity());
        }
    }
}
