package study.spring.todo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBeanDI.class, TestUser.class, TestTodo.class })
public class AllTests {
	//Test Suite
}
