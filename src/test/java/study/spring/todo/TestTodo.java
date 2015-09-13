package study.spring.todo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import study.spring.todo.constant.Repeat;
import study.spring.todo.model.Todo;
import study.spring.todo.service.TodoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"file:src/main/webapp/WEB-INF/spring/appServlet/beans.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/database.xml"
})
public class TestTodo {
	private static String title = "@테스트제목@";
	private static String content = "@테스트내용@abcd##$$%%\\''";
	private static Repeat repeat = Repeat.NONE;
	private static DateTime stdDay = new DateTime(2014,10,1,7,21,37);
	private static DateTime varDay = new DateTime(2014,10,1,7,21,37);
		
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
		todo.setTitle(title);
		todo.setContent(content);
		todo.setRepeatType(repeat);
		todo.setStdDay(stdDay);
		todo.setVarDay(varDay);
		
		todoService.newTodo(todo);
	}
	
	@Test
	public void testTodo지우기() throws Exception{
		todoService.removeTodo(3);
	}
}
