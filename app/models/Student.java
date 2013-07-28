package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple model class used for form data retrieval.
 * Note that to implement persistence, this class should extend play.db.ebean.Model.
 * @author Philip Johnson
 */
public class Student  {
  private static final long serialVersionUID = -2206212996405933705L;
  private String name;
  private String password;
  private List<Hobby> hobbies = new ArrayList<>();
  private GradeLevel gradeLevel;
  private String gpa;
  private List<Major> majors = new ArrayList<>();
  
  
  public String toString() {
    return String.format("[Student %s %s]", this.name, this.password);
  }
}
