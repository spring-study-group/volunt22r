package study.spring.todo.repeat.impl;

import java.util.Collection;
import java.util.HashSet;

import org.joda.time.DateTime;

import study.spring.todo.repeat.RepeatParam;
import study.spring.todo.repeat.RepeatStrategy;

public class Every2Years implements RepeatStrategy<RepeatParam, Long> {

	@Override
	public Collection<Long> getRepeat(RepeatParam param) {
		Collection<Long> days = new HashSet<Long>();
		DateTime date = param.getTodo().getStdDay();
		
		DateTime stdDate = param.getStandardDay();

		//2년마다 한 번씩이므로 year % 2가 같은 해일 경우만 포함
		//todo 생성일 이후이면서 같은 달에만 달력 표시
		if(((date.getYear()%2)==(stdDate.getYear()%2))
				&& (date.getYear() <= stdDate.getYear()) && (date.getMonthOfYear() == stdDate.getMonthOfYear())){
			days.add(new DateTime(stdDate.getYear(),date.getMonthOfYear(),date.getDayOfMonth(),date.getHourOfDay(),date.getMinuteOfHour()).getMillis());
		}
		
		return days;
	}

}
