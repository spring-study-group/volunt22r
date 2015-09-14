package study.spring.todo.service;

import study.spring.todo.auth.AuthParam;
import study.spring.todo.auth.AuthResult;
import study.spring.todo.dao.UserDao;
import study.spring.todo.model.User;

public class UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	public UserDao getUserDao(){
		return userDao;
	}
	
	public AuthResult login(AuthParam param){
		return null;
	}
	
	public AuthResult logout(AuthParam param){
		return null;
	}
	
	public User getUser(String mail){
		return userDao.getUser(mail);
	}
}
