package POJO;

public class UserPOJO {
  private String id;
  private String name;
  private String id_account;
  private String address;
  private boolean admin;
  public UserPOJO() {
  }
  public UserPOJO(String id, String name, String id_account, String address, boolean admin) {
    this.id = id;
    this.name = name;
    this.id_account = id_account;
    this.address = address;
    this.admin = admin;
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
  public String getId_account() {
    return id_account;
  }
  public void setId_account(String id_account) {
    this.id_account = id_account;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public boolean isAdmin() {
    return admin;
  }
  public void setAdmin(boolean admin) {
    this.admin = admin;
  }
  @Override
  public String toString() {
    return id +" - "+ name ;
  }
}
