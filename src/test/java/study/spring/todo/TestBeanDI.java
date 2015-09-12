package study.spring.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import study.spring.todo.constant.Repeat;
import study.spring.todo.dao.TodoDao;
import study.spring.todo.dao.UserDao;
import study.spring.todo.service.TodoService;
import study.spring.todo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"file:src/main/webapp/WEB-INF/spring/appServlet/beans.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/database.xml"
})
public class TestBeanDI {
	
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void testUserServicDI(){
		UserService userService = (UserService)ctx.getBean("userService");
		Assert.notNull(userService,"userService is null!!");
		Assert.notNull(userService.getUserDao(),"userDao injection fail, userDao is null in UserService");
	}
	
	@Test
	public void testTodoServicDI(){
		TodoService todoService = (TodoService)ctx.getBean("todoService");
		Assert.notNull(todoService,"todoService is null!!");
		Assert.notNull(todoService.getRepeatStrategy(),"repeatStrategies injection fail, strategy map is null");
		for(Repeat repeat : Repeat.values()){
			Assert.notNull(todoService.getRepeatStrategy().get(repeat),repeat+" strategy is null");
		}
	}
	
	@Test
	public void testTodoDao(){
		TodoDao dao = (TodoDao)ctx.getBean("todoDao");
		Assert.notNull(dao,"dao injection fail, todoDao is null");
		Assert.notNull(dao.getSessionFactory(),"user dao session factory is null");
	}
	
	@Test
	public void testUserDao(){
		UserDao dao = (UserDao)ctx.getBean("userDao");
		Assert.notNull(dao,"dao injection fail, userDao is null");
		Assert.notNull(dao.getSessionFactory(), "todo dao session factory is null");
	}
}
