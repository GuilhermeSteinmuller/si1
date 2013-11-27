package models;

import java.util.ArrayList;
import java.util.List;


import play.data.validation.Constraints.*;
import play.db.ebean.*;
import play.db.ebean.Model.Finder;
import play.data.validation.Constraints.*;

import javax.persistence.*;


@Entity
public class Task extends Model implements Comparable<Task>{

	@Id
	public Long id;
	@Required
	public String label;
	@Required
	public String descricao;
	@Required
	public int prioridade;
	@Required
	public boolean notDone = true;
	
	public static Finder<Long,Task> find = new Finder(
			    Long.class, Task.class
			  );
	
	public static List<Task> all(){
		return find.all();
	}
	
	public static void create(Task task){
		task.save();
	}
	
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
	
	public static void update(Long id){
		Task task = find.ref(id);
		task.setNotDone(false);
	    task.update();
	}

	@Override
	public int compareTo(Task o) {
		 return this.getPrioridade() - o.getPrioridade();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isNotDone() {
		return notDone;
	}

	public void setNotDone(boolean notDone) {
		this.notDone = notDone;
	}
	
	
	 public static List<Task> tasksDoneRefresh(List<Task> tasks){
         List<Task> refreshedList = new ArrayList<Task>();
         
         for(Task task : tasks){
                 if(!task.isNotDone())
                         refreshedList.add(task);
         }
         return refreshedList;
 }
	
	 public static List<Task> tasksNotDoneRefresh(List<Task> tasks){
         List<Task> refreshedList = new ArrayList<Task>();
         
         
         for(Task task : tasks){
                 if(task.isNotDone())
                         refreshedList.add(task);
         }
         return refreshedList;
 }


	
	
	
	
	
}
