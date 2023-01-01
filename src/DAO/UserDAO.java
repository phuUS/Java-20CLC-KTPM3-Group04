package DAO;

import POJO.UserPOJO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    public static ArrayList<UserPOJO> getAll(){
        ArrayList<UserPOJO> result = null;
        Connection connection = Database.createConnection();
        try {
            result = new ArrayList<>();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM user";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String idAccount = rs.getString("id_account");
                String address = rs.getString("address");
                int role = rs.getInt("role");
                UserPOJO User = new UserPOJO(id, name, idAccount, address, role);
                result.add(User);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserPOJO.class.getName()).log(Level.SEVERE, null, ex);
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
