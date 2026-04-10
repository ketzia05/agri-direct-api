package coreJavaVersion;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        		MarketPlace m = new MarketPlace();
        		
    			Buyer b = new Buyer(1, "Muthu");
    			b.buyProduct(m, "Tomato", 30);
    	        
    	        m.viewAllProducts();
    }
}