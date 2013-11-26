package models;

import java.util.ArrayList;
import java.util.List;


import play.data.validation.Constraints.*;
import play.db.ebean.*;
import play.db.ebean.Model.Finder;
import play.data.validation.Constraints.*;

import javax.persistence.*;


@Entity
public class Task extends Model {

	@Id
	public Long id;
	@Required
	public String label;
	public String descricao;
	public int prioridade;
	
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
	
	
	
	
	
}
