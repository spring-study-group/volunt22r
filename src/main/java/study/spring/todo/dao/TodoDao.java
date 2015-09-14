package study.spring.todo.dao;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import study.spring.todo.model.Todo;
import study.spring.todo.model.User;

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
	
	public void deleteTodo(int uid){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.load(Todo.class, uid));
		tx.commit();
	}
	
	public void updateTodo(Todo todo){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.update(todo);
		tx.commit();
	}
	
	public Collection<Todo> getTodoList(String userId){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria = criteria.add(Restrictions.eq("mail", userId));
		User user = (User)criteria.uniqueResult();
		System.err.println(user.getPassword());
		return user.getTodoList();
	}
}
