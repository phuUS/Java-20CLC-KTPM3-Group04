package src.business;

import java.util.ArrayList;

import src.dataaccess.AuthorDA;
import src.pojo.AuthorPojo;

public class AuthorBU {
	public ArrayList<AuthorPojo> getAllAuthor(){
		ArrayList<AuthorPojo> result = null;
		AuthorDA authorDA = new AuthorDA();
		result = authorDA.getAllAuthor();
		return result;
	}

  public boolean addAuthor(AuthorPojo author){
    AuthorDA authorDA = new AuthorDA();
    boolean res = authorDA.addAuthor(author);
    return res;
  }
  public boolean updateAuthor(AuthorPojo author){
    AuthorDA authorDA = new AuthorDA();
    boolean res = authorDA.updateAuthor(author);
    return res;
  }

  public ArrayList<AuthorPojo> getAuthorBySearch(String id, String name){
    AuthorDA authorDA = new AuthorDA();
    ArrayList<AuthorPojo> listAuthor = new ArrayList<>();
    listAuthor = authorDA.getAuthorBySearch(id,name);
    return listAuthor;
  }

  public boolean enableAuthor(AuthorPojo author){
    AuthorDA authorDA  = new AuthorDA();
    boolean res = authorDA.enableAuthor(author);
    return res;
  }

  public boolean disableAuthor(AuthorPojo author){
    AuthorDA authorDA  = new AuthorDA();
    boolean res = authorDA.disableAuthor(author);
    return res;
  }
}
