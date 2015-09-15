package study.spring.todo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study.spring.todo.auth.impl.NativeAuth;

@Component
public class AuthResolver {
	@Autowired
	private NativeAuth nativeAuth;
	
	public AuthStrategy getAuthStrategy(AuthType type){
		switch(type){
			case NATIVE:
				return nativeAuth;
			default : throw new IllegalArgumentException(type+" is invalid auth type");
		}
	}
}
