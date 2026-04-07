package coreJavaVersion;

public class Main {
    public static void main(String[] args) {
    		System.out.println("!!!!!Welcome to AgriDirect!!!!!");
    		System.out.println();
        MarketPlace m = new MarketPlace();

        Farmer f1 = new Farmer(1, "Ravi");
        f1.addProduct(new Product("Tomato", 20, 50));
        f1.addProduct(new Product("Potato", 30, 20));
        System.out.println();
        Farmer f2 = new Farmer(2, "Kumar");
        f2.addProduct(new Product("Papaya", 35, 50));
        f2.addProduct(new Product("Corn", 50, 20));
        System.out.println();
        m.addFarmer(f1);
        m.addFarmer(f2);

        Buyer b = new Buyer(101, "Arun");
        System.out.println();
        b.viewProducts(m);
    }
}