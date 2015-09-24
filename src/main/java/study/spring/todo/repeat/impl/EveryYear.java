package study.spring.todo.repeat.impl;

import java.util.Collection;
import java.util.HashSet;

import org.joda.time.DateTime;

import study.spring.todo.model.Todo;
import study.spring.todo.repeat.RepeatParam;
import study.spring.todo.repeat.RepeatStrategy;

public class EveryYear implements RepeatStrategy<RepeatParam, Long> {

	@Override
	public Collection<Long> getRepeat(RepeatParam param) {
		Collection<Long> repeatDays = new HashSet<Long>(1);
		Todo todo = param.getTodo();
		DateTime date = todo.getStdDay();
		DateTime stdDate = param.getStandardDay();
		
		//todo가 있는 달이 아니면 패스
		if(date.getMonthOfYear() != stdDate.getMonthOfYear())
			return repeatDays;
		//todo를 만든 년도보다 작을 경우 패스
		if(date.getYear() > stdDate.getYear())
			return repeatDays;
		
		repeatDays.add(new DateTime(stdDate.getYear(),date.getMonthOfYear(),date.getDayOfMonth(),date.getHourOfDay(),date.getMinuteOfHour()).getMillis());
		
		return repeatDays;
	}

}
