package coreJavaVersion;

class Buyer extends User {

    public Buyer(int id, String name) {
        super(id, name, "Buyer");
        System.out.println("Buyer created: " + name + " (ID: " + id + ")");
    }
    
    public void viewProducts(MarketPlace m) {
    		m.showAllProducts();
    }
    
    public void buyProduct(MarketPlace m, String name, int qty) {
    		m.buyFarmerProducts(name, qty);
    }
}
