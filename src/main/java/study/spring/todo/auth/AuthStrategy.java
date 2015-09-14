package study.spring.todo.auth;

public interface AuthStrategy<I,O> {
	public O auth(I param);
}
