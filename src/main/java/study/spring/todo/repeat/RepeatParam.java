package study.spring.todo.repeat;

import org.joda.time.DateTime;

import study.spring.todo.model.Todo;

public class RepeatParam {
	private Todo todo;
	private DateTime standardDay;

	public Todo getTodo() {
		return todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}

	public DateTime getStandardDay() {
		return standardDay;
	}

	public void setStandardDay(DateTime standardDay) {
		this.standardDay = standardDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((standardDay == null) ? 0 : standardDay.hashCode());
		result = prime * result + ((todo == null) ? 0 : todo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepeatParam other = (RepeatParam) obj;
		if (standardDay == null) {
			if (other.standardDay != null)
				return false;
		} else if (!standardDay.equals(other.standardDay))
			return false;
		if (todo == null) {
			if (other.todo != null)
				return false;
		} else if (!todo.equals(other.todo))
			return false;
		return true;
	}
}
