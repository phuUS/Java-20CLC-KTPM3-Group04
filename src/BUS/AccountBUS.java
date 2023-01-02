package BUS;

import DAO.AccountDAO;
import POJO.AccountPOJO;

import java.util.ArrayList;

public class AccountBUS {
    public static ArrayList<AccountPOJO> getAll(){
        return AccountDAO.getAll();
    }
}