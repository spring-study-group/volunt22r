package study.spring.todo.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import study.spring.todo.constant.Repeat;

@Entity
@Table(name="todo")
public class Todo {
	@Id
	@GeneratedValue
	private int uid;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column(name="repeat_type", nullable=false)
	@Enumerated(EnumType.STRING)
	private Repeat repeatType;
	
	@Column(name="std_day", nullable=false, updatable=false)
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime stdDay;
	
	@Column(name="variable_std_day", nullable=false)
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime varDay;

	//insert default value, not updated
	@Column(name="insert_timestamp", nullable=false, insertable=false, updatable=false)
	private Timestamp insert;
	
	//insert default, update auto
	@Column(name="modified_timestamp", nullable=false, insertable=false, updatable=false)
	private Timestamp modified;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Repeat getRepeatType() {
		return repeatType;
	}

	public void setRepeatType(Repeat repeatType) {
		this.repeatType = repeatType;
	}

	public DateTime getStdDay() {
		return stdDay;
	}

	public void setStdDay(DateTime stdDay) {
		this.stdDay = stdDay;
	}

	public DateTime getVarDay() {
		return varDay;
	}

	public void setVarDay(DateTime varDay) {
		this.varDay = varDay;
	}

	public Timestamp getInsert() {
		return insert;
	}

	public void setInsert(Timestamp insert) {
		this.insert = insert;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((insert == null) ? 0 : insert.hashCode());
		result = prime * result + ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + ((repeatType == null) ? 0 : repeatType.hashCode());
		result = prime * result + ((stdDay == null) ? 0 : stdDay.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + uid;
		result = prime * result + ((varDay == null) ? 0 : varDay.hashCode());
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
		Todo other = (Todo) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (insert == null) {
			if (other.insert != null)
				return false;
		} else if (!insert.equals(other.insert))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (repeatType != other.repeatType)
			return false;
		if (stdDay == null) {
			if (other.stdDay != null)
				return false;
		} else if (!stdDay.equals(other.stdDay))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (uid != other.uid)
			return false;
		if (varDay == null) {
			if (other.varDay != null)
				return false;
		} else if (!varDay.equals(other.varDay))
			return false;
		return true;
	}
}
