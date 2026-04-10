package coreJavaVersion;

import java.sql.SQLException;

class MarketPlace {
	
	ProductDAO dao = new ProductDAO();
	
	public void addProduct(Farmer f, Product p) {
		f.addProduct(p);
		dao.saveProduct(p, f.getId());
    }
	
	public void viewAllProducts() throws SQLException {
		ProductDAO dao = new ProductDAO();
		dao.getAllProducts();
	}
	
	public void buyProduct(String name, int qty) throws SQLException {
	    ProductDAO dao = new ProductDAO();
	    dao.buyProduct(name, qty);
	}
}