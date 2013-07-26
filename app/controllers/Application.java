package controllers;

import static play.data.Form.form;
import models.Student;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.simpleform;

/**
 * The controller supporting two actions. Display shows the index page without the results of any
 * prior form submission. Submit processes the form submission from the index page and shows the
 * results through a redisplay of the index page.
 * 
 * @author Philip Johnson
 */
public class Application extends Controller {
  public static Form<Student> personForm = form(Student.class);

  /**
   * @return The index page upon initial display. No prior data.
   */
  public static Result renderHome() {
    return ok(index.render());
  }
  
  /**
   * @return The index page upon initial display. No prior data.
   */
  public static Result renderSimpleForm() {
    return ok(simpleform.render());
  }


}
