package controllers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Task;
import play.data.Form;
import play.mvc.*;
import play.i18n.Messages;
import play.api.i18n.Lang;


import views.html.*;

public class Application extends Controller {

	static Form<Task> taskForm = Form.form(Task.class);
	
	
    public static Result index() {
        return redirect(routes.Application.tasks());
    }

    public static Result tasks() {
        
        
        List<Task> doneTasks = Task.tasksDoneRefresh(Task.all());
        List<Task> notDoneTasks = Task.tasksNotDoneRefresh(Task.all());
        
        Collections.sort(doneTasks);
        Collections.reverse(notDoneTasks);
        
        return ok(views.html.index.render(doneTasks, notDoneTasks, taskForm));
    }

   
    public static Result newTask() {
        Form<Task> filledForm = taskForm.bindFromRequest();
        Collections.sort(Task.all());
        List<Task> doneTasks = Task.tasksDoneRefresh(Task.all());
        List<Task> notDoneTasks = Task.tasksNotDoneRefresh(Task.all());
        
        
       
        if (filledForm.hasErrors()){
                
            
           
           
            return badRequest(views.html.index.render(notDoneTasks, doneTasks, taskForm));
        } else {
                Task.create(filledForm.get());
                return redirect(routes.Application.tasks());        
        }
    }
    
    public static Result deleteTask(Long id){
    	Task.delete(id);
    	  return redirect(routes.Application.tasks());
    }
    
    
    public static Result updateTask(Long id){
        Task.update(id);
        return redirect(routes.Application.tasks());
}

}
