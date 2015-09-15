package study.spring.todo.auth.impl;

import org.springframework.stereotype.Component;

import study.spring.todo.auth.AuthParam;
import study.spring.todo.auth.AuthResult;
import study.spring.todo.auth.AuthStrategy;
import study.spring.todo.model.User;

@Component
public class NativeAuth implements AuthStrategy{
	
	@Override
	public AuthResult auth(AuthParam param) {
		NativeAuthParam authParam = (NativeAuthParam)param;
		User user = authParam.getUserDao().getUser(authParam.getMail(),authParam.getPassword());
		return new AuthResult(user);
	}
}
