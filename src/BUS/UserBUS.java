package BUS;

import DAO.UserDAO;
import POJO.UserPOJO;

import java.util.ArrayList;

public class UserBUS {
    public static ArrayList<UserPOJO> getAll(){
        return UserDAO.getAll();
    }
}