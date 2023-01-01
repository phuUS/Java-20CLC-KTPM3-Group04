package BUS;

import DAO.BookDAO;
import POJO.BookPOJO;

import java.util.ArrayList;

public class BookBUS {
    public static ArrayList<BookPOJO> getAll(){
        return BookDAO.getAll();
    }
}
