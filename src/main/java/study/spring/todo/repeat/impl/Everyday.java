package study.spring.todo.repeat.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import study.spring.todo.parameter.RepeatParam;
import study.spring.todo.repeat.RepeatStrategy;

public class Everyday implements RepeatStrategy<RepeatParam,Date> {

	@Override
	public Collection<Date> getRepeat(RepeatParam param) {
		Collection<Date> days = new ArrayList<Date>();
		
		//need implementation
		
		return days;
	}

}
