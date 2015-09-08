package study.spring.todo.service;

import java.util.Collection;
import java.util.Date;

import study.spring.todo.dao.TodoDao;
import study.spring.todo.model.Todo;

public class TodoService {
	private TodoDao todoDao;
	
	public Collection<Todo> getTodoAfterDate(Date date){
		return null;
	}
	
	public Collection<Todo> getTodoAfterEqualDate(Date date){
		return null;
	}
	
	public Collection<Todo> getTodoBeforeDate(Date date){
		return null;
	}
	
	public Collection<Todo> getTodoBeforeEqualDate(Date date){
		return null;
	}
	
	public void newTodo(Todo todo){
		
	}
	
	public void removeTodo(Todo todo){
		
	}
	
	public void updateTodo(Todo todo){
		
	}
}
