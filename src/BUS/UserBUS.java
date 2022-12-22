package BUS;

import java.util.ArrayList;

import DAO.UserDAO;
import POJO.UserPOJO;

public class UserBUS {
  public ArrayList<UserPOJO> getAllUser(){
    UserDAO userDao = new UserDAO();
    ArrayList<UserPOJO> res = userDao.getAllUser();
    return res;
  }
}
