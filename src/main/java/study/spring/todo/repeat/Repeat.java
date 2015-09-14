package study.spring.todo.repeat;

import study.spring.todo.repeat.impl.Every2Days;
import study.spring.todo.repeat.impl.Every2Months;
import study.spring.todo.repeat.impl.Every2Weeks;
import study.spring.todo.repeat.impl.Every2Years;
import study.spring.todo.repeat.impl.EveryMonth;
import study.spring.todo.repeat.impl.EveryWeek;
import study.spring.todo.repeat.impl.EveryYear;
import study.spring.todo.repeat.impl.Everyday;
import study.spring.todo.repeat.impl.NoRepeat;

@SuppressWarnings("rawtypes")
public enum Repeat {
	NONE(new NoRepeat()),	EVERYDAY(new Everyday()), 
	EVERY_2DAYS(new Every2Days()),	EVERY_MONTH(new EveryMonth()), 
	EVERY_2MONTH(new Every2Months()),	EVERY_WEEK(new EveryWeek()), 
	EVERY_2WEEKS(new Every2Weeks()), 	EVERY_YEAR(new EveryYear()), 
	EVERY_2YEARS(new Every2Years());
	
	private RepeatStrategy strategy;
	
	private Repeat(RepeatStrategy strategy){
		this.strategy = strategy;
	}
	
	public RepeatStrategy getStrategy(){
		return strategy;
	}
}
