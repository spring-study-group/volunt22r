package study.spring.todo.repeat.impl;

import java.util.Collection;
import java.util.HashSet;

import org.joda.time.DateTime;

import study.spring.todo.repeat.RepeatParam;
import study.spring.todo.repeat.RepeatStrategy;

public class NoRepeat implements RepeatStrategy<RepeatParam, Long> {
	@Override
	public Collection<Long> getRepeat(RepeatParam param) {
		Collection<Long> repeatDays = new HashSet<Long>();
		DateTime stdDate = param.getStandardDay();
		DateTime todoDate = param.getTodo().getStdDay();
		//기준 월과 동일한 달이면 달력에 표시함
		if((stdDate.getYear() == todoDate.getYear()) && (stdDate.getMonthOfYear() == todoDate.getMonthOfYear())){
			repeatDays.add(todoDate.getMillis());
		}
		return repeatDays;
	}
}
