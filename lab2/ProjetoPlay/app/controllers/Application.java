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
        List<Task> tarefas = Task.all();
        Collections.sort(tarefas);
        Collections.reverse(tarefas);
        List<Task> doneTasks = new ArrayList<Task>();
        List<Task> notDoneTasks = new ArrayList<Task>();
        for (Task t: tarefas){
                if (t.isNotDone()){
                        notDoneTasks.add(t);
                } else {
                        doneTasks.add(t);
                }
        }
             
            return ok(views.html.index.render(doneTasks, notDoneTasks, taskForm));
    }

   
    public static Result newTask() {
        Form<Task> filledForm = taskForm.bindFromRequest();
        if (filledForm.hasErrors()){
                
            List<Task> tarefas = Task.all();
            Collections.sort(tarefas);
            Collections.reverse(tarefas);
            List<Task> doneTasks = new ArrayList<Task>();
            List<Task> notDoneTasks = new ArrayList<Task>();
            for (Task t: tarefas){
                    if (t.isNotDone()){
                            notDoneTasks.add(t);
                    } else {
                            doneTasks.add(t);
                    }
            }
            
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
    
    
    
   /* public static Result updateTask(Long id) {
        Form<Task> taskForm = Form.form(Task.class).bindFromRequest();
        if (taskForm.hasErrors()) {
            return badRequest(views.html.index.render(Task.all(), taskForm));
        } else {
        	
            Task.update(id, taskForm.get());
            return redirect(routes.Application.tasks());
        }
    }*/

}
