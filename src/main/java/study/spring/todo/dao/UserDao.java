package study.spring.todo.dao;

import org.hibernate.SessionFactory;

public class UserDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
}
