package study.spring.todo.service;

import org.springframework.beans.factory.annotation.Autowired;

import study.spring.todo.auth.AuthParam;
import study.spring.todo.auth.AuthResolver;
import study.spring.todo.auth.AuthResult;
import study.spring.todo.dao.UserDao;
import study.spring.todo.model.User;

public class UserService {
	@Autowired
	private AuthResolver authResolver;
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	public UserDao getUserDao(){
		return userDao;
	}
	
	public AuthResult login(AuthParam param){
		return authResolver.getAuthStrategy(param.getType()).auth(param);
	}
	
	public AuthResult logout(AuthParam param){
		return null;
	}
	
	public User getUser(String mail){
		return userDao.getUser(mail);
	}
}
