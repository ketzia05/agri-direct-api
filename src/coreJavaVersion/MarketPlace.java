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
}