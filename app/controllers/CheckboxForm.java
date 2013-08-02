package controllers;

import static play.data.Form.form;
import java.util.HashMap;
import java.util.Map;
import models.Hobby;
import models.Student;
import play.api.templates.Html;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.checkboxform;

public class CheckboxForm extends Controller {
  
  /**
   * @return Render and return the simpleform0 (mockup) page.
   * Although the page contains a form, we are not binding the form data or action buttons so
   * they do nothing in this page. 
   */
  public static Result getCheckboxForm() {
    Form<Student> studentForm = form(Student.class);
    // Make a Map indicating the hobbies that this student has.
    Map<Hobby, Boolean> hobbyMap = new HashMap<>();
    hobbyMap.put(new Hobby(1L, "Surfing"), true);
    hobbyMap.put(new Hobby(2L, "Biking"), false);
    Html renderedContent = checkboxform.render(studentForm, hobbyMap);
    // Send the HTML back to the client.
    return ok(renderedContent);
  }
  
  public static Result postCheckboxForm() {
    // Retrieve the submitted form data from the request object.
    
    Form<Student> studentForm = form(Student.class).bindFromRequest();
    //DynamicForm studentForm = form().bindFromRequest();
    //System.out.println("Form data: "  + studentForm.data());


    // Do something with the data.  Normally we'd save it to the database or whatever.
    Student student = studentForm.get();
    System.out.println("Student is: " + student);
    
    // Make a Map indicating the hobbies that this student has.
    Map<Hobby, Boolean> hobbyMap = new HashMap<>();
    hobbyMap.put(new Hobby(1L, "Surfing"), true);
    hobbyMap.put(new Hobby(2L, "Biking"), false);
    // Now return something to the client. Let's just render and return the same form data. 
    return ok(checkboxform.render(form(Student.class), hobbyMap));
  }
}
