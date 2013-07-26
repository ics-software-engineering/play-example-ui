package models;

import play.db.ebean.Model;

public class Hobby extends Model {
  
  private String name;
  
  public Hobby(String name) {
    this.name = name;
  }

}
