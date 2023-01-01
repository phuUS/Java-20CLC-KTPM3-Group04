package BUS;

import DAO.BookDAO;
import POJO.BookPOJO;

import java.util.ArrayList;

public class BookBUS {
    public static ArrayList<BookPOJO> getAll(){
        return BookDAO.getAll();
    }

    public static BookPOJO getOne(String bookId){
        return BookDAO.getOne(bookId);
    }

    public static Boolean updateOne(String oldBookId, BookPOJO modifiedBook){
        return BookDAO.updateOne(oldBookId,modifiedBook);
    }

    public static Boolean insertOne(BookPOJO book){
        return BookDAO.insertOne(book);
    }

    public static Boolean enable(String bookId){
        return BookDAO.enable(bookId);
    }

    public static Boolean disable(String bookId){
        return BookDAO.disable(bookId);
    }

    public static ArrayList<BookPOJO> getBookNotDisable(){
        return BookDAO.getBookNotDisable();
    }
}
