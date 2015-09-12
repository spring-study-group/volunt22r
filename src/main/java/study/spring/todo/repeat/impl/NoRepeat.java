package study.spring.todo.repeat.impl;

import java.util.Collection;
import java.util.Date;

import study.spring.todo.parameter.RepeatParam;
import study.spring.todo.repeat.RepeatStrategy;

public class NoRepeat implements RepeatStrategy<RepeatParam, Date> {

	@Override
	public Collection<Date> getRepeat(RepeatParam param) {
		// TODO Auto-generated method stub
		return null;
	}

}
