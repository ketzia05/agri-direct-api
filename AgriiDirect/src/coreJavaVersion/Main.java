package coreJavaVersion;

import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
    		
    		Scanner s = new Scanner(System.in);
    		
    		Connection con = DBConnection.getConnection();
    		
    		
    		
    		try {
    				String query = "insert into users(id, name, role) values (?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);
				
				System.out.println("Enter Your ID: ");
				ps.setInt(1, s.nextInt());
				s.nextLine();
				System.out.println("Enter Your name: ");
				ps.setString(2, s.nextLine());
				System.out.println("Enter Your role: ");
				ps.setString(3, s.nextLine());
				
				ps.executeUpdate();
				
				String selectQuery = "SELECT * FROM users";

				PreparedStatement ps2 = con.prepareStatement(selectQuery);

				ResultSet rs = ps2.executeQuery();

				while (rs.next()) {
				    System.out.println(
				        rs.getInt("id") + " " +
				        rs.getString("name") + " " +
				        rs.getString("role")
				    );
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    			s.close();
        
    }
}