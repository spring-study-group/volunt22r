package study.spring.todo.service;

import study.spring.todo.dao.UserDao;
import study.spring.todo.parameter.AuthParam;
import study.spring.todo.result.AuthResult;

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
}
