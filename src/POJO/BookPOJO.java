package POJO;

public class BookPOJO {
    String id;
    String name;
    String idPublisher;
    Integer price;

    public BookPOJO(String id, String name, String idPublisher, Integer price) {
        this.id = id;
        this.name = name;
        this.idPublisher = idPublisher;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(String idPublisher) {
        this.idPublisher = idPublisher;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
