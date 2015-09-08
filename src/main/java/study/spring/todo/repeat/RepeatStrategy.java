package study.spring.todo.repeat;

import java.util.Collection;

public interface RepeatStrategy <I,O>{
	Collection<O> getRepeat(I param);
}
