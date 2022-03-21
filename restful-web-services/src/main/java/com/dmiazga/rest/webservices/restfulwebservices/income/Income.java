package com.dmiazga.rest.webservices.restfulwebservices.income;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Income {
	@Id
	@GeneratedValue
	private Long incomeid;
	private String username;
	private String description;
	private Date targetDate;
	private Date finishDate;
	private Double amount;
	private String comment;
	private String cycle;

	public Income() {
	}

	public Income(
			long incomeid, 
			String username, 
			String description, 
			Date targetDate, 
			Date finishDate, 
			double amount, 
			String comment, 
			String cycle) {

		super();
		this.incomeid = incomeid;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.finishDate = finishDate;
		this.amount = amount;
		this.comment = comment;
		this.cycle = cycle;
	}

	public Long getId() {
		return incomeid;
	}

	public void setId(Long incomeid) {
		this.incomeid = incomeid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
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
