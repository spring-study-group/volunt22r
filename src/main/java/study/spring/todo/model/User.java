package study.spring.todo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import study.spring.todo.constant.UserStatus;

@Entity
@Table(name="todo_user")
public class User {

	@Id
	@GeneratedValue
	private int uid;
	
	@Column(nullable=false, unique=true)
	private String mail;
	
	@Column(nullable=false)
	private String password;
	
	@Column(name="join_day", nullable=false, insertable=false, updatable=false)
	private Date joinDay;
	
	@Column(name="withdraw_day", insertable=false)
	private Date withdrawDay;
	
	@Column(name="status", nullable=false, insertable=false)
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoinDay() {
		return joinDay;
	}

	public void setJoinDay(Date joinDay) {
		this.joinDay = joinDay;
	}

	public Date getWithdrawDay() {
		return withdrawDay;
	}

	public void setWithdrawDay(Date withdrawDay) {
		this.withdrawDay = withdrawDay;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joinDay == null) ? 0 : joinDay.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + uid;
		result = prime * result + ((withdrawDay == null) ? 0 : withdrawDay.hashCode());
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
		User other = (User) obj;
		if (joinDay == null) {
			if (other.joinDay != null)
				return false;
		} else if (!joinDay.equals(other.joinDay))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status != other.status)
			return false;
		if (uid != other.uid)
			return false;
		if (withdrawDay == null) {
			if (other.withdrawDay != null)
				return false;
		} else if (!withdrawDay.equals(other.withdrawDay))
			return false;
		return true;
	}
}
