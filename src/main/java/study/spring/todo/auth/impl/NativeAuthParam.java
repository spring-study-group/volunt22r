package study.spring.todo.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import study.spring.todo.auth.AuthParam;
import study.spring.todo.auth.AuthType;
import study.spring.todo.dao.UserDao;

@Component
@Scope(value="prototype")
public class NativeAuthParam extends AuthParam{
	@Autowired
	private UserDao userDao;
	
	private String mail;
	private String password;

	public NativeAuthParam(){
		type = AuthType.NATIVE;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
