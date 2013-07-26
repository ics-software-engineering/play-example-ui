package models;

import java.util.ArrayList;
import java.util.List;
import play.db.ebean.Model;

/**
 * Simple model class used for form data retrieval.
 * @author Philip Johnson
 */
public class Student extends Model {
  private static final long serialVersionUID = -2206212996405933705L;
  private String name;
  private String password;
  private List<Hobby> hobbies = new ArrayList<>();
  private GradeLevel gradeLevel;
  private String gpa;
  private List<Major> majors = new ArrayList<>();

}
