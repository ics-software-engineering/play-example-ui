package controllers;

import play.api.templates.Html;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * The controller for the home page of this application.
 * 
 * @author Philip Johnson
 */
public class Application extends Controller {

  /**
   * @return Render and return the index page.
   */
  public static Result getIndex() {
    // Convert the index.scala.html template into HTML.
    Html renderedContent = index.render();
    // Send the HTML back to the client.
    return ok(renderedContent);
  }
  
 

}
