package study.spring.todo.auth;

public interface AuthStrategy {
	public AuthResult auth(AuthParam param);
}
