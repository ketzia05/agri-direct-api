package coreJavaVersion;

import java.sql.*;

class ProductDAO {

    public void saveProduct(Product p, int farmerId) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO products (id, name, price, quantity, farmer_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setInt(3, p.getPrice());
            ps.setInt(4, p.getQuantity());
            ps.setInt(5, farmerId);

            ps.executeUpdate();

            System.out.println("Product stored in DB!");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getAllProducts() throws SQLException {
    		Connection con = DBConnection.getConnection();
    		
    		String query = "Select * from products";
    		
    		PreparedStatement ps = con.prepareStatement(query);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		System.out.println("Available Products (From DB): ");
    		
    		while(rs.next()) {
    			System.out.println(rs.getString(2)+" - ₹"+rs.getInt(3)+" Qty: "+rs.getInt(4)+" (Farmer ID: "+rs.getInt(5)+")");
    		}
    		
    		con.close();
    		ps.close();
    		rs.close();
    }
    
    public void buyProduct(String name, int qty) throws SQLException {
    		Connection con = DBConnection.getConnection();
    		
    		PreparedStatement ps = con.prepareStatement("Select quantity from products where name = ?");
    		ps.setString(1, name);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		int quantity = 0;
    		
    		name = name.trim();
    		
    		if(rs.next()) {
    			quantity = rs.getInt("quantity");
    			if(qty <= 0) {
    				System.out.println("Invalid Quantity");
    				return;
    			}
    			if(quantity < qty) {
        			System.out.println("Insufficient Stocks");
        		}
        		else {
        			System.out.println("Purchase Successful");
        			ps = con.prepareStatement("update products set quantity = quantity - ? where name = ?");
        			ps.setInt(1, qty);
        			ps.setString(2, name);
        			int row = ps.executeUpdate();
        			if(row>0) {
        				System.out.println("Remaining quantity updated");
        			}
        		}
    		}
    		else {
    			System.out.println("Product not found");
    		}
    		
    		
    		
    }
}
