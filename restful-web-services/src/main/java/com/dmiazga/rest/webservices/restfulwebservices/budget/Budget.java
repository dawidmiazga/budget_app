package com.dmiazga.rest.webservices.restfulwebservices.budget;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Budget {
	@Id
	@GeneratedValue
	private Long budgetid;
	private String username;
	private Date targetMonth;
	private Double amount;
	private String comment;
	
	public Budget() {
	}

	public Budget(
			long budgetid, 
			String username, 
			Date targetMonth, 
			double amount,
			String comment) {
		super();
		this.budgetid = budgetid;
		this.username = username;
		this.targetMonth = targetMonth;
		this.amount = amount;
		this.comment = comment;
	}

	public Long getId() {
		return budgetid;
	}

	public void setId(Long budgetid) {
		this.budgetid = budgetid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getTargetMonth() {
		return targetMonth;
	}
	
	public void setTargetMonth(Date targetMonth) {
		this.targetMonth = targetMonth;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (budgetid ^ (budgetid >>> 32));
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
		Budget other = (Budget) obj;
		if (budgetid != other.budgetid)
			return false;
		return true;
	}
}