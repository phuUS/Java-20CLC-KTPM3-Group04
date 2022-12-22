package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import POJO.UserPOJO;

public class UserDAO {
  public ArrayList<UserPOJO> getAllUser(){
    ArrayList<UserPOJO> listUser = new ArrayList<>();
    Connection conn = null;
    try {
      conn = Database.createConnection();
      String query = "SELECT * FROM user";
      PreparedStatement prst = conn.prepareStatement(query);
      ResultSet res = prst.executeQuery();
      while(res.next()){
        String id = res.getString("id");
        String name = res.getString("name");
        String id_account = res.getString("id_account");
        String address = res.getString("address");
        boolean role = res.getBoolean("role");
        UserPOJO user = new UserPOJO(id, name, id_account, address, role);
        listUser.add(user);
      }
      res.close();
      prst.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }finally{
      if(conn!=null){
        try {
          conn.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

    return listUser;
  }
}
