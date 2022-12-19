package business;

import java.util.ArrayList;

import dataaccess.PublisherDA;
import pojo.PublisherPojo;


public class PublisherBU {
	public ArrayList<PublisherPojo> getAllPublisher(){
		ArrayList<PublisherPojo> result = null;
		PublisherDA publisherDA = new PublisherDA();
		result = publisherDA.getAllPublisher();
		return result;
	}

  public boolean addPublisher(PublisherPojo publisher){
    PublisherDA publisherDA = new PublisherDA();
    boolean res = publisherDA.addPublisher(publisher);
    return res;
  }
  public boolean updatePublisher(PublisherPojo publisher){
    PublisherDA publisherDA = new PublisherDA();
    boolean res = publisherDA.updatePublisher(publisher);
    return res;
  }

  public ArrayList<PublisherPojo> getPublisherBySearch(String id, String name){
    PublisherDA publisherDA = new PublisherDA();
    ArrayList<PublisherPojo> listAuthor = new ArrayList<>();
    listAuthor = publisherDA.getPublisherBySearch(id,name);
    return listAuthor;
  }

  public boolean enablePublisher(PublisherPojo publisher){
    PublisherDA publisherDA  = new PublisherDA();
    boolean res = publisherDA.enablePublisher(publisher);
    return res;
  }

  public boolean disablePublisher(PublisherPojo publisher){
    PublisherDA publisherDA  = new PublisherDA();
    boolean res = publisherDA.disablePublisher(publisher);
    return res;
  }
}

