package BUS;

import DAO.PublisherDAO;
import POJO.PublisherPOJO;

import java.util.ArrayList;

public class PublisherBUS {
    public static ArrayList<PublisherPOJO> getAll(){
        return PublisherDAO.getAll();
    }

    public static ArrayList<String> getAllId(){
        ArrayList<String> result = new ArrayList<>();
        ArrayList<PublisherPOJO> publishers = getAll();
        for (PublisherPOJO publisher : publishers) {
            result.add(publisher.getId());
        }

        return result;
    }
}
