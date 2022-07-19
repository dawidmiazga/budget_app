package com.dmiazga.budgetapp.budget;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Budget {
	@Id
	@GeneratedValue
	private Long budgetid;
	private Long usernameid;
	private Date target_month;
	private Double amount;
	private String comment;
	
	public Budget() {
	}

	public Budget(
			long budgetid, 
			long usernameid, 
			Date target_month, 
			double amount,
			String comment) {
		super();
		this.budgetid = budgetid;
		this.usernameid = usernameid;
		this.target_month = target_month;
		this.amount = amount;
		this.comment = comment;
	}

	public Long getBudgetid() {
		return budgetid;
	}

	public void setBudgetid(Long budgetid) {
		this.budgetid = budgetid;
	}

	public Long getUsernameid() {
		return usernameid;
	}

	public void setUsernameid(Long usernameid) {
		this.usernameid = usernameid;
	}

	public Date getTarget_month() {
		return target_month;
	} 
	
	public void setTarget_month(Date target_month) {
		this.target_month = target_month;
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

	public Long getId() {
		return budgetid;
	}

	public void setId(Long budgetid) {
		this.budgetid = budgetid;
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