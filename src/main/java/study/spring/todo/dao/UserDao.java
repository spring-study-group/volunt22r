package study.spring.todo.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import study.spring.todo.model.User;

public class UserDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	public User getUser(String mail){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("mail", mail));
		User user = (User)criteria.uniqueResult();
		session.getTransaction().commit();
		return user;
	}
	
	public User getUser(String mail, String password){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("mail", mail));
		criteria.add(Restrictions.eq("password", password));
		User user = (User)criteria.uniqueResult();
		session.getTransaction().commit();
		return user;
	}
}
