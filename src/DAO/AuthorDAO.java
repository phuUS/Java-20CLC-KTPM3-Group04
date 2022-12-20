package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import POJO.AuthorPOJO;

public class AuthorDAO {
	public ArrayList<AuthorPOJO> getAllAuthor (){
		ArrayList<AuthorPOJO> result = null ;
		try {
			result = new ArrayList<AuthorPOJO>();
			Connection conn = Database.createConnection();
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM author";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
        Boolean disable = rs.getBoolean("is_disable");
				
				AuthorPOJO author = new AuthorPOJO(id,name,address,phone,disable);
				result.add(author);
			}
			rs.close();
			statement.close();
      conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

  public boolean addAuthor(AuthorPOJO author){
    boolean ans = true;
    Connection conn = null;
    
    try {
      conn = Database.createConnection();
      String query = "INSERT INTO author(id, name, address, phone) VALUES (?,?,?,?)";
      PreparedStatement prst = conn.prepareStatement(query);
      prst.setString(1, author.getId());
      prst.setString(2, author.getName());
      prst.setString(3, author.getAddress());
      prst.setString(4, author.getPhone());

      int rows = prst.executeUpdate();
      if(rows <1){
        ans = false;
      }
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

    return ans;
  }

  public boolean updateAuthor(AuthorPOJO author){
    boolean res = true;
    Connection conn = null;
    try {
      conn = Database.createConnection();
      String query = "UPDATE author SET author.name = ?, author.address = ?, author.phone = ? WHERE author.id = ?";
      PreparedStatement prst = conn.prepareStatement(query);
      prst.setString(1, author.getName());
      prst.setString(2, author.getAddress());
      prst.setString(3, author.getPhone());
      prst.setString(4, author.getId());
      int rows = prst.executeUpdate();
      if(rows < 1){
        res = false;
      }

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

    return res;
  }

  public ArrayList<AuthorPOJO> getAuthorBySearch(String id, String name){
    Connection conn = null;
    ArrayList<AuthorPOJO> listAuthor = null;
    try {
      listAuthor = new ArrayList<AuthorPOJO>();
      conn = Database.createConnection();
      String query;
      if(!id.equals("") && name.equals("")){
        query = "SELECT * FROM author WHERE author.id = ?";
      }else if(id.equals("") && !name.equals("")){
        query = "SELECT * FROM author WHERE author.name = ?";
      }else if(!id.equals("") && !name.equals("")){
        query = "SELECT * FROM author WHERE author.id = ? AND author.name = ?";
      }else{
        return null;
      }
      PreparedStatement prst = conn.prepareStatement(query);
      if(!id.equals("") && name.equals("")){
        prst.setString(1, id);
      }else if(id.equals("") && !name.equals("")){
        prst.setString(1, name);
      }else if(!id.equals("") && !name.equals("")){
        prst.setString(1, id);
        prst.setString(2, name);
      }
      ResultSet res = prst.executeQuery();
      while(res.next()){
        String _id = res.getString("id");
        String _name = res.getString("name");
        String address = res.getString("address");
        String phone = res.getString("phone");
        Boolean disable = res.getBoolean("is_disable");
        AuthorPOJO author = new AuthorPOJO(_id, _name, address, phone, disable);
        listAuthor.add(author);
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
    return listAuthor;
  }

  public boolean enableAuthor(AuthorPOJO author){
    boolean ans = true;
    Connection conn = null;

    try {
      conn = Database.createConnection();
      String query = "UPDATE author SET author.name = ?, author.address = ?, author.phone = ?, author.is_disable = false WHERE author.id = ?";
      PreparedStatement prst = conn.prepareStatement(query);
      prst.setString(1, author.getName());
      prst.setString(2, author.getAddress());
      prst.setString(3, author.getPhone());
      prst.setString(4, author.getId());

      int rows = prst.executeUpdate();
      if(rows<1){
        ans = false;
      }
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
    return ans;
  }

  public boolean disableAuthor(AuthorPOJO author){
    boolean ans = true;
    Connection conn = null;

    try {
      conn = Database.createConnection();
      String query = "UPDATE author SET author.name = ?, author.address = ?, author.phone = ?, author.is_disable = true WHERE author.id = ?";
      PreparedStatement prst = conn.prepareStatement(query);
      prst.setString(1, author.getName());
      prst.setString(2, author.getAddress());
      prst.setString(3, author.getPhone());
      prst.setString(4, author.getId());

      int rows = prst.executeUpdate();
      if(rows<1){
        ans = false;
      }
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
    return ans;

  }

}
