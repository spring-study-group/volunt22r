package study.spring.todo;

import java.sql.SQLException;
import java.util.Collection;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import study.spring.todo.model.Todo;
import study.spring.todo.repeat.Repeat;
import study.spring.todo.service.TodoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"file:src/main/webapp/WEB-INF/spring/appServlet/beans.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/database.xml"
})
public class TestRelation {
	private static String title = "@테스트제목@";
	private static String content = "@테스트내용@abcd##$$%%\\''";
	private static Repeat repeat = Repeat.NONE;
	private static DateTime stdDay = new DateTime(2014,10,1,7,21,37);
	private static DateTime varDay = new DateTime(2014,10,1,7,21,37);
	
	@Autowired
	private TodoService todoService;	

	@Test
	public void test() throws SQLException {
		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setContent(content);
		todo.setRepeatType(repeat);
		todo.setStdDay(stdDay);
		todo.setVarDay(varDay);
		
		todo.setUserMail("volunt22r@naver.com");
		todoService.newTodo(todo);
		
		todo.setTitle(title+"2");
		todo.setContent(content+"2");
		todoService.newTodo(todo);
		
		todo.setTitle(title+"3");
		todo.setContent(content+"3");
		todoService.newTodo(todo);
		
		Collection<Todo> todoList = todoService.getTodoList("volunt22r@naver.com");
		
		Assert.notEmpty(todoList);
	}
}
