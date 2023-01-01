package DAO;

import POJO.BookPOJO;

import java.sql.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDAO {
    public static ArrayList<BookPOJO> getAll(){
        ArrayList<BookPOJO> result = null;
        Connection connection = Database.createConnection();
        try {
            result = new ArrayList<>();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM book";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String id_publisher = rs.getString("id_publisher");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                int totalPurchase = rs.getInt("total_purchase");
                Date releaseDate = rs.getDate("release_date");
                Boolean enabled = rs.getBoolean("enabled");
                BookPOJO book = new BookPOJO(id, name, id_publisher, price, stock, totalPurchase, releaseDate, enabled);
                result.add(book);
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

    public static ArrayList<BookPOJO> getNewBooks(){
        ArrayList<BookPOJO> result = null;
        Connection connection = Database.createConnection();
        try {
            result = new ArrayList<>();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM book WHERE release_date >= (DATE_SUB(CURDATE(), INTERVAL 1 MONTH))";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String id_publisher = rs.getString("id_publisher");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                int totalPurchase = rs.getInt("total_purchase");
                Date releaseDate = rs.getDate("release_date");
                Boolean enabled = rs.getBoolean("enabled");
                BookPOJO book = new BookPOJO(id, name, id_publisher, price, stock, totalPurchase, releaseDate, enabled);
                result.add(book);
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

    public static ArrayList<BookPOJO> getHotBooks(){
        ArrayList<BookPOJO> result = null;
        Connection connection = Database.createConnection();
        try {
            result = new ArrayList<>();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM book WHERE total_purchase > 100";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String id_publisher = rs.getString("id_publisher");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                int totalPurchase = rs.getInt("total_purchase");
                Date releaseDate = rs.getDate("release_date");
                Boolean enabled = rs.getBoolean("enabled");
                BookPOJO book = new BookPOJO(id, name, id_publisher, price, stock, totalPurchase, releaseDate, enabled);
                result.add(book);
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

    public static ArrayList<BookPOJO> getOutOfStockBooks(){
        ArrayList<BookPOJO> result = null;
        Connection connection = Database.createConnection();
        try {
            result = new ArrayList<>();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM book WHERE stock <= 0";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String id_publisher = rs.getString("id_publisher");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                int totalPurchase = rs.getInt("total_purchase");
                Date releaseDate = rs.getDate("release_date");
                Boolean enabled = rs.getBoolean("enabled");
                BookPOJO book = new BookPOJO(id, name, id_publisher, price, stock, totalPurchase, releaseDate, enabled);
                result.add(book);
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

    public static ArrayList<BookPOJO> getBookNotDisable(){
        ArrayList<BookPOJO> result = null;
        Connection connection = Database.createConnection();
        try {
            result = new ArrayList<>();
            Statement statement;
            statement = connection.createStatement();
            String query = "select * from book where book.enabled = 1";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String id_publisher = rs.getString("id_publisher");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                int totalPurchase = rs.getInt("total_purchase");
                Boolean enabled = rs.getBoolean("enabled");
                BookPOJO book = new BookPOJO(id, name, id_publisher, price, stock, totalPurchase, enabled);
                result.add(book);
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

    public static BookPOJO getOne(String bookId){
        BookPOJO result = null;
        Connection connection = Database.createConnection();
        try {
            String sql = "SELECT * FROM book WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bookId);

            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String id_publisher = rs.getString("id_publisher");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                int totalPurchase = rs.getInt("total_purchase");
                Date releaseDate = rs.getDate("release_date");
                Boolean enabled = rs.getBoolean("enabled");
                result = new BookPOJO(id, name, id_publisher, price, stock, totalPurchase, releaseDate, enabled);
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

    public static Boolean updateOne(String oldBookId, BookPOJO modifiedBook){
        boolean result = false;
        Connection connection = Database.createConnection();
        try {
            String sql = "UPDATE book SET id=?, name=?, id_publisher=?, price=?, stock=?," +
                    " total_purchase=?, release_date=?, enabled=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            int i = 1;
            statement.setString(i++, modifiedBook.getId());
            statement.setString(i++, modifiedBook.getName());
            statement.setString(i++, modifiedBook.getIdPublisher());
            statement.setString(i++, modifiedBook.getPrice().toString());
            statement.setString(i++, modifiedBook.getStock().toString());
            statement.setString(i++, modifiedBook.getTotalPurchase().toString());
            statement.setDate(i++, new java.sql.Date(modifiedBook.getReleaseDate().getTime()));
            statement.setInt(i++, modifiedBook.isEnabled() ? 1 : 0);
            statement.setString(i, oldBookId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
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

    public static Boolean insertOne(BookPOJO book){
        boolean result = false;
        Connection connection = Database.createConnection();
        try {
            String sql = "INSERT INTO book (id, name, id_publisher, price, stock," +
                    "total_purchase, release_date, enabled) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            int i = 1;
            statement.setString(i++, book.getId());
            statement.setString(i++, book.getName());
            statement.setString(i++, book.getIdPublisher());
            statement.setString(i++, book.getPrice().toString());
            statement.setString(i++, book.getStock().toString());
            statement.setString(i++, book.getTotalPurchase().toString());
            statement.setDate(i++, new java.sql.Date(book.getReleaseDate().getTime()));
            statement.setInt(i, book.isEnabled() ? 1 : 0);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
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

    public static Boolean enable(String bookId){
        boolean result = false;
        Connection connection = Database.createConnection();
        try {
            String sql = "UPDATE book SET enabled=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "1");
            statement.setString(2, bookId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
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

    public static Boolean disable(String bookId){
        boolean result = false;
        Connection connection = Database.createConnection();
        try {
            String sql = "UPDATE book SET enabled=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "0");
            statement.setString(2, bookId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }

            sql = "DELETE FROM promotion_book where id_book=?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, bookId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0){
                System.out.println("Deleted " + rowsDeleted + " rows in promotion_book table with id_book=" + bookId);
                result = true;
            }

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
