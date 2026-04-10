package coreJavaVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(
            		"jdbc:oracle:thin:@localhost:1521:orcl",
    				"scott",
    				"tiger"
            );

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

        return con;
    }
}
