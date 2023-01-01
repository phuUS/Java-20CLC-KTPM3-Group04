package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import POJO.PublisherPojo;



public class PublisherDAO {
  public static ArrayList<PublisherPojo> getAll(){
        ArrayList<PublisherPojo> result = null;
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
                PublisherPojo publisher = new PublisherPojo(id, name, address, phone, is_disable);
                result.add(publisher);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
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

	public ArrayList<PublisherPojo> getAllPublisher (){
		ArrayList<PublisherPojo> result = null ;
		try {
			result = new ArrayList<PublisherPojo>();
			Connection conn = Database.createConnection();
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM publisher";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
        Boolean disable = rs.getBoolean("is_disable");
				
				PublisherPojo publisher = new PublisherPojo(id,name,address,phone,disable);
				result.add(publisher);
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

  public ArrayList<PublisherPojo> getPublisherNotDisable (){
		ArrayList<PublisherPojo> result = null ;
		try {
			result = new ArrayList<PublisherPojo>();
			Connection conn = Database.createConnection();
			Statement statement = conn.createStatement();
			String query = "select * from publisher where publisher.is_disable = false";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
        Boolean disable = rs.getBoolean("is_disable");
				
				PublisherPojo publisher = new PublisherPojo(id,name,address,phone,disable);
				result.add(publisher);
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

  public boolean addPublisher(PublisherPojo publisher){
    boolean ans = true;
    Connection conn = null;
    
    try {
      conn = Database.createConnection();
      String query = "INSERT INTO publisher(id, name, address, phone) VALUES (?,?,?,?)";
      PreparedStatement prst = conn.prepareStatement(query);
      prst.setString(1, publisher.getId());
      prst.setString(2, publisher.getName());
      prst.setString(3, publisher.getAddress());
      prst.setString(4, publisher.getPhone());

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

  public boolean updatePublisher(PublisherPojo publisher){
    boolean res = true;
    Connection conn = null;
    try {
      conn = Database.createConnection();
      String query = "UPDATE publisher SET publisher.name = ?, publisher.address = ?, publisher.phone = ? WHERE publisher.id = ?";
      PreparedStatement prst = conn.prepareStatement(query);
      prst.setString(1, publisher.getName());
      prst.setString(2, publisher.getAddress());
      prst.setString(3, publisher.getPhone());
      prst.setString(4, publisher.getId());
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

  public ArrayList<PublisherPojo> getPublisherBySearch(String id, String name){
    Connection conn = null;
    ArrayList<PublisherPojo> listPublisher = null;
    try {
      listPublisher = new ArrayList<PublisherPojo>();
      conn = Database.createConnection();
      String query;
      if(!id.equals("") && name.equals("")){
        query = "SELECT * FROM publisher WHERE publisher.id = ?";
      }else if(id.equals("") && !name.equals("")){
        query = "SELECT * FROM publisher WHERE publisher.name = ?";
      }else if(!id.equals("") && !name.equals("")){
        query = "SELECT * FROM publisher WHERE publisher.id = ? AND publisher.name = ?";
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
        PublisherPojo publisher = new PublisherPojo(_id, _name, address, phone, disable);
        listPublisher.add(publisher);
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
    return listPublisher;
  }

  public boolean enablePublisher(PublisherPojo publisher){
    boolean ans = true;
    Connection conn = null;

    try {
      conn = Database.createConnection();
      String query = "UPDATE publisher SET publisher.name = ?, publisher.address = ?, publisher.phone = ?, publisher.is_disable = false WHERE publisher.id = ?";
      PreparedStatement prst = conn.prepareStatement(query);
      prst.setString(1, publisher.getName());
      prst.setString(2, publisher.getAddress());
      prst.setString(3, publisher.getPhone());
      prst.setString(4, publisher.getId());

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

  public boolean disablePublisher(PublisherPojo publisher){
    boolean ans = true;
    Connection conn = null;

    try {
      conn = Database.createConnection();
      String query = "UPDATE publisher SET publisher.name = ?, publisher.address = ?, publisher.phone = ?, publisher.is_disable = true WHERE publisher.id = ?";
      PreparedStatement prst = conn.prepareStatement(query);
      prst.setString(1, publisher.getName());
      prst.setString(2, publisher.getAddress());
      prst.setString(3, publisher.getPhone());
      prst.setString(4, publisher.getId());

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
