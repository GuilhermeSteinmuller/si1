package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return redirect(routes.Application.tasks());
    }

    public static Result helloWorld() {
        return ok(helloWorld.render("Hello world",1));
}  
    
    public static Result tasks(){
    	return TODO;
    }
    
    public static Result newTask(){
    	return TODO;
    }
    
    public static Result deleteTask(Long id){
    	return TODO;
    }
    

}
