package DAO;

import POJO.BookPOJO;
import POJO.PromotionPOJO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PromotionDAO {
    public static ArrayList<PromotionPOJO> getAll(){
        ArrayList<PromotionPOJO> result = null;
        Connection connection = Database.createConnection();
        try {
            result = new ArrayList<>();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM promotion";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                Double percent = rs.getDouble("percent");
                String applyOption = rs.getString("apply_option");
                Integer limitOrders = rs.getInt("limit_orders");
                Boolean enabled = rs.getBoolean("enabled");
                PromotionPOJO promotion = new PromotionPOJO(id, name, description,
                        startDate, endDate, percent, applyOption, limitOrders, enabled);
                result.add(promotion);
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

    public static PromotionPOJO getOne(String promotionId){
        PromotionPOJO result = null;
        Connection connection = Database.createConnection();
        try {
            String sql = "SELECT * FROM promotion WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, promotionId);

            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                Double percent = rs.getDouble("percent");
                String applyOption = rs.getString("apply_option");
                Integer limitOrders = rs.getInt("limit_orders");
                Boolean enabled = rs.getBoolean("enabled");
                result = new PromotionPOJO(id, name, description,
                        startDate, endDate, percent, applyOption, limitOrders, enabled);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PromotionPOJO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Boolean updateOne(String oldPromotionId, PromotionPOJO modifiedPromotion){
        boolean result = false;
        Connection connection = Database.createConnection();
        try {
            String sql = "UPDATE promotion SET id=?, name=?, description=?, start_date=?, end_date=?," +
                    " percent=?, apply_option=?, limit_orders=?, enabled=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            int i = 1;
            statement.setString(i++, modifiedPromotion.getId());
            statement.setString(i++, modifiedPromotion.getName());
            statement.setString(i++, modifiedPromotion.getDescription());
            statement.setDate(i++, new java.sql.Date(modifiedPromotion.getStartDate().getTime()));
            statement.setDate(i++, new java.sql.Date(modifiedPromotion.getEndDate().getTime()));
            statement.setDouble(i++, modifiedPromotion.getPercent());
            statement.setString(i++, modifiedPromotion.getApplyOption());
            statement.setInt(i++, modifiedPromotion.getLimitOrders());
            statement.setInt(i++, modifiedPromotion.isEnabled() ? 1 : 0);
            statement.setString(i, oldPromotionId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PromotionPOJO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Boolean insertOne(PromotionPOJO promotion){
        boolean result = false;
        Connection connection = Database.createConnection();
        try {
            String sql = "INSERT INTO promotion (id, name, description, start_date, end_date," +
                    " percent, apply_option, limit_orders, enabled) VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            int i = 1;
            statement.setString(i++, promotion.getId());
            statement.setString(i++, promotion.getName());
            statement.setString(i++, promotion.getDescription());
            statement.setDate(i++, new java.sql.Date(promotion.getStartDate().getTime()));
            statement.setDate(i++, new java.sql.Date(promotion.getEndDate().getTime()));
            statement.setDouble(i++, promotion.getPercent());
            statement.setString(i++, promotion.getApplyOption());
            statement.setInt(i++, promotion.getLimitOrders());
            statement.setInt(i, promotion.isEnabled() ? 1 : 0);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PromotionPOJO.class.getName()).log(Level.SEVERE, null, ex);
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


    public static Boolean enable(String promotionId){
        boolean result = false;
        Connection connection = Database.createConnection();
        try {
            String sql = "UPDATE promotion SET enabled=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "1");
            statement.setString(2, promotionId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PromotionPOJO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Boolean disable(String promotionId){
        boolean result = false;
        Connection connection = Database.createConnection();
        try {
            String sql = "UPDATE promotion SET enabled=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "0");
            statement.setString(2, promotionId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PromotionPOJO.class.getName()).log(Level.SEVERE, null, ex);
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
