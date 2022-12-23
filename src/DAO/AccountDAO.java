package DAO;

import POJO.AccountPOJO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDAO {
    public static ArrayList<AccountPOJO> getAll(){
        ArrayList<AccountPOJO> result = null;
        Connection connection = Database.createConnection();
        try {
            result = new ArrayList<>();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM account";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                AccountPOJO account = new AccountPOJO(id, username, password);
                result.add(account);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountPOJO.class.getName()).log(Level.SEVERE, null, ex);
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
