package study.spring.todo;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Collection;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import study.spring.todo.model.Todo;
import study.spring.todo.repeat.Repeat;
import study.spring.todo.repeat.RepeatParam;

public class TestRepeat {

	private DateTime makeDate(String date){
		return DateTimeFormat.forPattern("yyyyMMdd HH:mm").parseDateTime(date);
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testNoRepeat() {
		DateTime date = makeDate("20150503 03:30");
		DateTime stdDate = makeDate("20150512 10:10");
		Todo todo = new Todo();
		todo.setStdDay(stdDate);
		
		RepeatParam param = new RepeatParam();
		param.setStandardDay(date);
		param.setTodo(todo);
		Collection<Long> result = Repeat.NONE.getStrategy().getRepeat(param);
		assertThat("result size must be 1",result.size(),is(1));
		assertThat("todo date must be "+stdDate.toString(),result,hasItem(stdDate.getMillis()));
		
		date = makeDate("20150401 12:20");
		param.setStandardDay(date);
		result = Repeat.NONE.getStrategy().getRepeat(param);
		assertThat("result size must be 0",result.size(),is(0));
		
		date = makeDate("20130103 12:20");
		param.setStandardDay(date);
		result = Repeat.NONE.getStrategy().getRepeat(param);
		assertThat("result size must be 0",result.size(),is(0));
		
		date = makeDate("20150601 02:20");
		param.setStandardDay(date);
		result = Repeat.NONE.getStrategy().getRepeat(param);
		assertThat("result size must be 0",result.size(),is(0));
		
	}

}