package study.spring.todo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import study.spring.todo.model.Todo;

public class TodoDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	public Integer insertNewTodo(Todo todo){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Integer uid = (Integer)session.save(todo);
		tx.commit();
		return uid;
	}
}
