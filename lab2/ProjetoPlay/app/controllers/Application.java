package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok("Hello world");
    }

    public static Result helloWorld() {
        return ok(helloWorld.render("Hello world",1));
}  

}
