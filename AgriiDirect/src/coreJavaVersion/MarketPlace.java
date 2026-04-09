package coreJavaVersion;

import java.util.*;

class MarketPlace {
    private List<Farmer> farmers = new ArrayList<>();

    public void addFarmer(Farmer f) {
        farmers.add(f);
    }

    public void showAllProducts() {
    		System.out.println("!!!Available Products!!!");
        for (Farmer f : farmers) {
            System.out.println("Farmer: " + f.getName());
            for (Product p : f.getProducts()) {
                System.out.println(
                    p.getName() + " - ₹" + p.getPrice() + " - Qty: " + p.getQuantity()
                );
            }
            System.out.println();
        }
    }
    
    public void buyFarmerProducts(String name, int qty) {
    		for(Farmer f : farmers) {
    			for(Product p : f.getProducts()) {
    				if(p.getName().equalsIgnoreCase(name)) {
    					if(p.getQuantity() < qty) {
    						System.out.println("Insufficient Quantity");
    					}
    					else {
    						p.reduceQuantity(qty);
    						System.out.println("Purchased " + qty + "kg of " + name +
    							    " from " + f.getName() +
    							    ". Remaining: " + p.getQuantity());
    					}
    					System.out.println();
    					return;
    				}
    			}
    		}
    		System.out.println("Product not found");
    }
}