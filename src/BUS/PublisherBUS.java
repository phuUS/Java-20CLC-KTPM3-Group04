package BUS;

import java.util.ArrayList;

import DAO.PublisherDAO;
import POJO.PublisherPojo;


public class PublisherBUS {
	public ArrayList<PublisherPojo> getAllPublisher(){
		ArrayList<PublisherPojo> result = null;
		PublisherDAO publisherDA = new PublisherDAO();
		result = publisherDA.getAllPublisher();
		return result;
	}

  public ArrayList<PublisherPojo> getPublisherNotDisable(){
		ArrayList<PublisherPojo> result = null;
		PublisherDAO publisherDA = new PublisherDAO();
		result = publisherDA.getPublisherNotDisable();
		return result;
	}

  public boolean addPublisher(PublisherPojo publisher){
    PublisherDAO publisherDA = new PublisherDAO();
    boolean res = publisherDA.addPublisher(publisher);
    return res;
  }
  public boolean updatePublisher(PublisherPojo publisher){
    PublisherDAO publisherDA = new PublisherDAO();
    boolean res = publisherDA.updatePublisher(publisher);
    return res;
  }

  public ArrayList<PublisherPojo> getPublisherBySearch(String id, String name){
    PublisherDAO publisherDA = new PublisherDAO();
    ArrayList<PublisherPojo> listAuthor = new ArrayList<>();
    listAuthor = publisherDA.getPublisherBySearch(id,name);
    return listAuthor;
  }

  public boolean enablePublisher(PublisherPojo publisher){
    PublisherDAO publisherDA  = new PublisherDAO();
    boolean res = publisherDA.enablePublisher(publisher);
    return res;
  }

  public boolean disablePublisher(PublisherPojo publisher){
    PublisherDAO publisherDA  = new PublisherDAO();
    boolean res = publisherDA.disablePublisher(publisher);
    return res;
  }
  public static ArrayList<PublisherPojo> getAll(){
        return PublisherDAO.getAll();
    }

    public static ArrayList<String> getAllId(){
        ArrayList<String> result = new ArrayList<>();
        ArrayList<PublisherPojo> publishers = getAll();
        for (PublisherPojo publisher : publishers) {
            result.add(publisher.getId());
        }

        return result;
    }
}
