package coreJavaVersion;

import java.sql.SQLException;

class Buyer extends User {

    public Buyer(int id, String name) {
        super(id, name, "Buyer");
        System.out.println("Buyer created: " + name + " (ID: " + id + ")");
    }
    
    public void buyProduct(MarketPlace m, String name, int qty) throws SQLException {
    		m.buyProduct(name, qty);
    }
}
