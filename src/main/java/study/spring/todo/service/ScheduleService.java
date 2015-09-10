package study.spring.todo.service;

public class ScheduleService {
	private TodoService todoService;
	
	public void setTodoService(TodoService todoService){
		this.todoService = todoService;
	}
	
	public TodoService getTodoService() {
		return todoService;
	}

	public void changeStandardDay(){
		
	}
}
