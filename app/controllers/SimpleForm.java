package controllers;

import static play.data.Form.form;
import java.util.ArrayList;
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
import views.html.simpleform0;
import views.html.simpleform1;
import views.html.simpleform2;
import views.html.simpleform3;

/**
 * Controller for all the SimpleForm pages. 
 */
public class SimpleForm extends Controller {
  
  /**
   * @return Render and return the simpleform0 (mockup) page.
   * Although the page contains a form, we are not binding the form data or action buttons so
   * they do nothing in this page. 
   */
  public static Result getSimpleForm0() {
    // Convert the simpleformmockup.scala.html template into HTML.
    Html renderedContent = simpleform0.render();
    // Send the HTML back to the client.
    return ok(renderedContent);
  }
  
  /**
   * @return Render and return the simpleform1 page.  
   * Now we do minimal form binding: we create a Student Form instance,
   * then pass that in 
   */
  public static Result getSimpleForm1() {
    // Convert the simpleform1.scala.html template into HTML.
    Html renderedContent = simpleform1.render();
    // Send the HTML back to the client.
    return ok(renderedContent);
  }
  
  public static Result postSimpleForm1() {
    // Retrieve the submitted form data from the request object.
    Map<String, String[]> formValues = request().body().asFormUrlEncoded();
    // Convert the form data into a Student model instance. 
    Student student = Student.makeInstance(formValues);
    // Do something with the data.  Normally we'd save it to the database or whatever.
    System.out.println("Student is: " + student);
    // Now return something to the client. Let's just render and return the same form data. 
    return ok(simpleform1.render());
  }
  
  /**
   * @return Render and return the simpleform2 page.  
   * Now we do minimal form binding: we create a Student Form instance,
   * then pass that in 
   */
  public static Result getSimpleForm2() {
    Student student = new Student("Joe Smith", "foodoo", new ArrayList<Hobby>());
    // Convert the simpleform1.scala.html template into HTML.
    Html renderedContent = simpleform2.render(student.name, student.password);
    // Send the HTML back to the client.
    return ok(renderedContent);
  }
  
  public static Result postSimpleForm2() {
    // Retrieve the submitted form data from the request object.
    Map<String, String[]> formValues = request().body().asFormUrlEncoded();
    // Convert the form data into a Student model instance. 
    Student student = Student.makeInstance(formValues);
    // Do something with the data.  Normally we'd save it to the database or whatever.
    System.out.println("Student is: " + student);
    // Now return something to the client. Let's just render and return the same form data. 
    return ok(simpleform2.render(student.name, student.password));
  }
  
  /**
   * @return Render and return the simpleform3 page.  
   * Now we do minimal form binding: we create a Student Form instance,
   * then pass that in 
   */
  public static Result getSimpleForm3() {
    Student student = new Student("Joe Smith", "foodoo", new ArrayList<Hobby>());
    // Make a Map indicating the hobbies that this student has.
    Map<String, Boolean> hobbyMap = new HashMap<>();
    hobbyMap.put("Surfing", true);
    hobbyMap.put("Biking", false);
    Html renderedContent = simpleform3.render(student.name, student.password, hobbyMap);
    // Send the HTML back to the client.
    return ok(renderedContent);
  }
  
  public static Result postSimpleForm3() {
    // Retrieve the submitted form data from the request object.
    Map<String, String[]> formValues = request().body().asFormUrlEncoded();
    // Convert the form data into a Student model instance. 
    Student student = Student.makeInstance(formValues);
    // Do something with the data.  Normally we'd save it to the database or whatever.
    System.out.println("Student is: " + student);
    // Now return something to the client. Let's just render and return the same form data. 
    return ok(simpleform3.render(student.name, student.password, Hobby.makeHobbyMap(student)));
  }
}
