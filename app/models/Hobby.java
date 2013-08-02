package models;

public class Hobby {
  
  private long id;
  private String name;
  
  public Hobby() {}
  
  public Hobby(long id, String name) {
    this.id = id;
    this.name = name;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public long getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }

}
