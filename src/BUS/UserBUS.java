package BUS;

import java.util.ArrayList;

import DAO.UserDAO;
import POJO.UserPOJO;

public class UserBUS {
  public ArrayList<UserPOJO> getUserNotDisable(){
    UserDAO userDao = new UserDAO();
    ArrayList<UserPOJO> res = userDao.getUserNotDisable();
    return res;
  }
}
