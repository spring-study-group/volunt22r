package study.spring.todo.repeat.impl;

import java.util.Collection;
import java.util.Date;

import org.joda.time.DateTime;

import study.spring.todo.parameter.RepeatParam;
import study.spring.todo.repeat.RepeatStrategy;

public class NoRepeat implements RepeatStrategy<RepeatParam, DateTime> {

	@Override
	public Collection<DateTime> getRepeat(RepeatParam param) {
		// TODO Auto-generated method stub
		return null;
	}

}
