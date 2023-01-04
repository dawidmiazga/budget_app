package com.dmiazga.budgetapp.bankaccount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bankaccount {
	@Id
	@GeneratedValue
	private Long bankaccountid;
	private String bankaccountname;
	private Long usernameid;
	private String comment;
	private Double divide;

	public Bankaccount() {
	}

	public Bankaccount(long bankaccountid, String bankaccountname, long usernameid, String comment, double divide) {
		super();
		this.bankaccountid = bankaccountid;
		this.bankaccountname = bankaccountname;
		this.usernameid = usernameid;
		this.comment = comment;
		this.divide = divide;
	}

	public Long getBankaccountid() {
		return bankaccountid;
	}

	public void setBankaccountid(Long bankaccountid) {
		this.bankaccountid = bankaccountid;
	}

	public String getBankaccountname() {
		return bankaccountname;
	}

	public void setBankaccountname(String bankaccountname) {
		this.bankaccountname = bankaccountname;
	}

	public Long getUsernameid() {
		return usernameid;
	}

	public void setUsernameid(Long usernameid) {
		this.usernameid = usernameid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Double getDivide() {
		return divide;
	}

	public void setDivide(Double divide) {
		this.divide = divide;
	}

	public Long getId() {
		return bankaccountid;
	}

	public void setId(Long bankaccountid) {
		this.bankaccountid = bankaccountid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bankaccountid ^ (bankaccountid >>> 32));
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
		Bankaccount other = (Bankaccount) obj;
		if (bankaccountid != other.bankaccountid)
			return false;
		return true;
	}
}