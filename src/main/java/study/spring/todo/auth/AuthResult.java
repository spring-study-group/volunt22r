package study.spring.todo.auth;

import study.spring.todo.model.User;

public class AuthResult {
	protected User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public AuthResult(User user){
		this.user = user;
	}
}
