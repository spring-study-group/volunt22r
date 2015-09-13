package study.spring.todo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import study.spring.todo.constant.Repeat;
import study.spring.todo.model.Todo;
import study.spring.todo.service.TodoService;

public class TestTodo {
	@Autowired
	private TodoService todoService;	

	private Session getSession(){
		return todoService.getTodoDao().getSessionFactory().getCurrentSession();
	}
	
	@After
	public void closeTransactionWhenErrorOccured(){
		Transaction tx = getSession().getTransaction();
		if(tx.isActive()){
			tx.rollback();
		}
	}
	
	@Test
	public void test새Todo넣기() throws Exception{
		Todo todo = new Todo();
		todo.setTitle("제목");
		todo.setContent("내용내용");
		todo.setRepeatType(Repeat.NONE);
		todo.setStdDay(new DateTime(2015,9,13,9,0,0));
		todo.setVarDay(todo.getStdDay());
		todoService.newTodo(todo);
	}
}
