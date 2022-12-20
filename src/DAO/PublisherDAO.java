package DAO;

import POJO.BookPOJO;
import POJO.PublisherPOJO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PublisherDAO {
    public static ArrayList<PublisherPOJO> getAll(){
        ArrayList<PublisherPOJO> result = null;
        Connection connection = Database.createConnection();
        try {
            result = new ArrayList<>();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM publisher";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Boolean is_disable = rs.getBoolean("is_disable");
                PublisherPOJO publisher = new PublisherPOJO(id, name, address, phone, is_disable);
                result.add(publisher);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookPOJO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }
}
