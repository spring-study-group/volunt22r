package study.spring.todo;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.inject.Provider;

import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import study.spring.todo.auth.AuthParam;
import study.spring.todo.auth.AuthResult;
import study.spring.todo.auth.AuthType;
import study.spring.todo.auth.impl.NativeAuth;
import study.spring.todo.auth.impl.NativeAuthParam;
import study.spring.todo.model.User;
import study.spring.todo.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"file:src/main/webapp/WEB-INF/spring/appServlet/beans.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/database.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class TestUser {
	private static String mail = "volunt22r@naver.com";
	private static String password = "암호화nono";
	private static String modifiedPassword = "바꾼비밀번호도암호화없이";
	
	@Autowired
	private UserService userService;
	
	private Session getSession(){
		return userService.getUserDao().getSessionFactory().getCurrentSession();
	}
	
	@Ignore
	@After
	public void closeTransactionWhenErrorOccured(){
		Transaction tx = getSession().getTransaction();
		if(tx.isActive()){
			tx.rollback();
		}
	}
	
	@Ignore
	@Test
	public void testCRUDUser(){
		User user = new User();
		user.setMail(mail);
		user.setPassword(password);
		
		//insert
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Integer uid = (Integer)session.save(user);
		assertNotNull("insert fail, uid is null",uid);
		tx.commit();
		
		//select
		session = getSession();
		session.beginTransaction();
		user = (User)session.createCriteria(User.class).add(Restrictions.eq("mail", mail)).uniqueResult();
		
		assertNotNull("select fail, "+mail+" is invalid user",user);
		
		//update
		user.setPassword(modifiedPassword);
		session.update(user);
		session.getTransaction().commit();
		
		//delete
		session = getSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}
	
	@Ignore
	@Test(expected=PropertyValueException.class)
	public void test_User의_mail주소없이_입력테스트(){
		User user = new User();
		user.setPassword(password);
		Session session = getSession();
		session.beginTransaction();
		session.save(user); //need mail
		session.getTransaction().commit();
	}
	
	@Ignore
	@Test(expected=PropertyValueException.class)
	public void test_User의_password없이_입력테스트(){
		User user = new User();
		user.setMail(mail);
		Session session = getSession();
		session.beginTransaction();
		session.save(user); //need mail
		session.getTransaction().commit();
	}
	
	@Autowired
	private Provider<NativeAuthParam> provider;
	
	@Test
	public void test_NativeAuthParam이_새_객체를_생성하는지(){
		NativeAuthParam auth1 = provider.get();
		NativeAuthParam auth2 = provider.get();
		assertNotSame(auth1, auth2);
	}
	
	@Autowired
	private NativeAuth nativeAuth;
	
	@Test
	public void test_id비밀번호인증테스트(){
		NativeAuthParam param = provider.get();
		param.setMail(mail);
		param.setPassword(password);
		param.setType(AuthType.NATIVE);
		AuthResult result = nativeAuth.auth(param);
		assertNotNull("user not found",result);
		assertNotNull("user is null",result.getUser());
	}
}
