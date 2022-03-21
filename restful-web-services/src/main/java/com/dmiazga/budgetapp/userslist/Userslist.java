package com.dmiazga.budgetapp.userslist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Userslist {
	@Id
	@GeneratedValue
	private Long usernameid;
	private String username;
	private String password;

	public Userslist() {
	}

	public Userslist(
			long usernameid, 
			String username, 
			String password) {

		super();
		this.usernameid = usernameid;
		this.username = username;
		this.password = password;
	}

	public String getLogin() {
		return username;
	}

	public void setLogin(String username) {
		this.username = username;
	}

	public Long getId() {
		return usernameid;
	}

	public void setId(Long usernameid) {
		this.usernameid = usernameid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (usernameid ^ (usernameid >>> 32));
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
		Userslist other = (Userslist) obj;
		if (usernameid != other.usernameid)
			return false;
		return true;
	}
}
