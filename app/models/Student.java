package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple model class used for form data retrieval.
 * Note that to implement persistence, this class should extend play.db.ebean.Model.
 * @author Philip Johnson
 */
public class Student {
  public Map<String, String> errorMap = new HashMap<>(); 
  public String name;
  public String password;
  public List<Hobby> hobbies = new ArrayList<>();
  //public GradeLevel gradeLevel;
  //public String gpa;
  //public List<Major> majors = new ArrayList<>();
  
  public Student () {
    // EBean wants a no-arg constructor.
  }
  
  public Student(String name, String password, List<Hobby> hobbies) {
    this.name = name;
    this.password = password;
    this.hobbies = hobbies;
  }
  
  /**
   * Creates a returns a new Student instance initialized from formValues.
   * If problems occur during binding, the errorMap field reports the problem(s).
   * Use hasErrors() to check if this instance is valid or not.  
   * @param formValues The values retrieved from the form.
   * @return A student instance. 
   */
  public static Student makeInstance(Map<String, String[]> formValues) {
    System.out.println("Form values: " + formValues);
    Student student = new Student();
    // Process Name field
    if (formValues.containsKey("Name")) {
      student.name = formValues.get("Name")[0];
    }
    else {
      student.errorMap.put("Name", "Required field name is missing.");
    }
    // Process Password field
    if (formValues.containsKey("Password")) {
      student.name = formValues.get("Password")[0];
    }
    else {
      student.errorMap.put("Password", "Required field name is missing.");
    }
    // Process Hobbies.
    student.hobbies = new ArrayList<Hobby>();
    if (formValues.containsKey("Hobbies[]")) {
      for (String hobbyName : formValues.get("Hobbies[]")) {
        System.out.println("Adding hobby: " + hobbyName);
        student.hobbies.add(new Hobby(0L, hobbyName));
      }
    }

    return student;
  }
  
  /**
   * @return True if this instance has an invalid state. 
   */
  public boolean hasErrors() {
    return !this.errorMap.isEmpty();
  }
  
  public String toString() {
    return String.format("[Student name: %s, password: %s, hobbies: %s]", 
        this.name, this.password, this.hobbies);
  }
  
}
