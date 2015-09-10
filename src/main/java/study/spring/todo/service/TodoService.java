package study.spring.todo.service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import study.spring.todo.constant.Repeat;
import study.spring.todo.dao.TodoDao;
import study.spring.todo.model.Todo;
import study.spring.todo.parameter.RepeatParam;
import study.spring.todo.repeat.RepeatStrategy;

public class TodoService {
	private TodoDao todoDao;
	private Map<Repeat,RepeatStrategy<RepeatParam,Date>> repeatStrategy;
	
	public void setTodoDao(TodoDao todoDao){
		this.todoDao = todoDao;
	}
	
	public TodoDao getTodoDao() {
		return todoDao;
	}

	public Map<Repeat, RepeatStrategy<RepeatParam, Date>> getRepeatStrategy() {
		return repeatStrategy;
	}

	public void setRepeatStrategy(Map<Repeat,RepeatStrategy<RepeatParam,Date>> strategy){
		this.repeatStrategy = strategy;
	}
	
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
