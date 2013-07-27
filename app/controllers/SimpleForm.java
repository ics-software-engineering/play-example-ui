package controllers;

import static play.data.Form.form;
import models.Student;
import play.api.templates.Html;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.simpleform1;
import views.html.simpleform0;

/**
 * Controller for all the SimpleForm pages. 
 */
public class SimpleForm extends Controller {
  
  /**
   * @return Render and return the simpleform0 (mockup) page.
   * Although the page contains a form, we are not binding the form data or action buttons so
   * they do nothing in this page. 
   */
  public static Result renderSimpleForm0() {
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
  public static Result renderSimpleForm1() {
    // Create a Form based upon the Student model. 
    Form<Student> studentForm = form(Student.class);
    // Convert the simpleform1.scala.html template into HTML, binding the HTML form in the template
    // to the Student model instance.
    Html renderedContent = simpleform1.render(studentForm);
    // Send the HTML back to the client.
    return ok(renderedContent);
  }
  
  public static Result saveSimpleForm1() {
    // Retrieve the submitted form data from the request object.
    Form<Student> studentForm = form(Student.class).bindFromRequest();
    // Convert the form data into a Student model instance. 
    Student student = studentForm.get();
    // Do something with the data.  Normally we'd save it to the database or whatever.
    System.out.println("Student is: " + student);
    // Now return something to the client. Let's just render and return the same form data. 
    return ok(simpleform1.render(studentForm));
  }
}
