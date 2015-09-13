package study.spring.todo;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import study.spring.todo.constant.Repeat;
import study.spring.todo.constant.UserStatus;
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
	private static String password = "암호화없는비밀번호";

	@Autowired
	private UserService userService;
	
	@Autowired
	private TodoService todoService;	
	
	private Session getSession(){
		return userService.getUserDao().getSessionFactory().getCurrentSession();
	}
	
	@After
	public void closeTransactionWhenErrorOccured(){
		Transaction tx = getSession().getTransaction();
		if(tx.isActive()){
			tx.rollback();
		}
	}
	
	@Test
	public void testCRUDUser(){
		User user = new User();
		user.setMail(mail);
		user.setPassword("테스트니깐암호화없이");
		
		//insert
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Integer uid = (Integer)session.save(user);
		Assert.notNull(uid,"insert fail, uid is null");
		tx.commit();
		
		//select
		session = getSession();
		session.beginTransaction();
		user = (User)session.createCriteria(User.class).add(Restrictions.eq("mail", mail)).uniqueResult();
		
		Assert.notNull(user,"select fail, "+mail+" is invalid user");
		
		//update
		user.setPassword("바꾼비밀번호역시암호화없이");
		session.update(user);
		session.getTransaction().commit();
		
		//delete
		session = getSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}
	
	@Test(expected=PropertyValueException.class)
	public void test_User의_mail주소없이_입력테스트(){
		User user = new User();
		user.setPassword("테스트비밀번호");
		Session session = getSession();
		session.beginTransaction();
		session.save(user); //need mail
		session.getTransaction().commit();
	}
	
	@Test(expected=PropertyValueException.class)
	public void test_User의_password없이_입력테스트(){
		User user = new User();
		user.setMail("test@spring.com");
		Session session = getSession();
		session.beginTransaction();
		session.save(user); //need mail
		session.getTransaction().commit();
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
