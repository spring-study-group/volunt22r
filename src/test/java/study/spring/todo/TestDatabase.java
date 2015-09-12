package study.spring.todo;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import study.spring.todo.model.Todo;
import study.spring.todo.model.User;
import study.spring.todo.service.TodoService;
import study.spring.todo.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"file:src/main/webapp/WEB-INF/spring/appServlet/beans.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/database.xml"
})
public class TestDatabase {
	private static String mail = "volunt22r@naver.com";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TodoService todoService;	
	
	@Test
	public void testInsertUser(){
		User user = new User();
		user.setMail(mail);
		user.setPassword("테스트니깐암호화없이");
		
		Session session = userService.getUserDao().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	@Test
	public void testUpdateUser(){
		Session session = userService.getUserDao().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		User user = (User)session.createCriteria(User.class).add(Restrictions.eq("mail", mail)).uniqueResult();
		user.setPassword("바꾼비밀번호역시암호화없이");
		
		session.update(user);
		session.getTransaction().commit();
		
	}
	
	@Test 
	public void testDeleteUser(){
		Session session = userService.getUserDao().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		User user = (User)session.createCriteria(User.class).add(Restrictions.eq("mail", mail)).uniqueResult();
		session.delete(user);
		
		session.getTransaction().commit();
		
	}
	
	@Test
	public void testInsertTodo(){
		
	}
	
	@Test
	public void testUpdateTodo(){
		
	}
	
	@Test
	public void testDeleteTodo(){
		
	}
	
	@Test
	public void testFindTodo(){
		
	}
}
