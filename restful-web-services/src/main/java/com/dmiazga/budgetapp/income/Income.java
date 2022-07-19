package com.dmiazga.budgetapp.income;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Income {
	@Id
	@GeneratedValue
	private Long incomeid;
	private Long usernameid;
	private String description;
	private Date target_date;
	private Date finish_date;
	private Double amount;
	private String comment;
	private String cycle;

	public Income() {
	}

	public Income(
			long incomeid, 
			long usernameid, 
			String description, 
			Date target_date, 
			Date finish_date, 
			double amount, 
			String comment, 
			String cycle) {

		super();
		this.incomeid = incomeid;
		this.usernameid = usernameid;
		this.description = description;
		this.target_date = target_date;
		this.finish_date = finish_date;
		this.amount = amount;
		this.comment = comment;
		this.cycle = cycle;
	}

	public Long getIncomeid() {
		return incomeid;
	}

	public void setIncomeid(Long incomeid) {
		this.incomeid = incomeid;
	}

	public Long getUsernameid() {
		return usernameid;
	}

	public void setUsernameid(Long usernameid) {
		this.usernameid = usernameid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTarget_date() {
		return target_date;
	}

	public void setTarget_date(Date target_date) {
		this.target_date = target_date;
	}
	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
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
	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public Long getId() {
		return incomeid;
	}

	public void setId(Long incomeid) {
		this.incomeid = incomeid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (incomeid ^ (incomeid >>> 32));
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
		Income other = (Income) obj;
		if (incomeid != other.incomeid)
			return false;
		return true;
	}
}
