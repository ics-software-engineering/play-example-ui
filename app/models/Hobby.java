package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hobby {
  
  private long id;
  private String name;
  private static List<Hobby> allHobbies = new ArrayList<>();
  
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
  
  public static Map<String, Boolean> makeHobbyMap(Student student) {
    Map<String, Boolean> hobbyMap = new HashMap<String, Boolean>();
    if (allHobbies.isEmpty()) {
      Hobby.initializeAllHobbies();
    }
    for (Hobby hobby : allHobbies) {
      hobbyMap.put(hobby.getName(), student.hasHobby(hobby.getName()));
    }
    return hobbyMap;
  }
  
  public static void initializeAllHobbies() {
    allHobbies.add(new Hobby(1L, "Surfing"));
    allHobbies.add(new Hobby(1L, "Biking"));
    allHobbies.add(new Hobby(1L, "Paddling"));
    allHobbies.add(new Hobby(1L, "Running"));
  }

}
