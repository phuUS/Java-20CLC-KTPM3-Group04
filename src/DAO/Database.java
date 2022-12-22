package DAO;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    public static Connection createConnection(){
        Connection connection = null;
        try {
            Driver myDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(myDriver);

            String DB_URL = "jdbc:mysql://java-project.czomp6y0wfdy.ap-southeast-1.rds.amazonaws.com:3306/book-store-management-db";
            String USER = "group04";
            String PASS = "Nguyenhuukhai2805";

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}