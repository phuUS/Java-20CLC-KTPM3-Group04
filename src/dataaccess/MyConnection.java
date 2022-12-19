package src.dataaccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


public class MyConnection {
	public static Connection create() {
		Connection conn = null;
		try {
			Driver myDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			
			String DB_URL = "jdbc:mySQL://java-project.czomp6y0wfdy.ap-southeast-1.rds.amazonaws.com:3306/book-store-management-db";
			String USER = "group04";
			String PASS = "Nguyenhuukhai2805";
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}