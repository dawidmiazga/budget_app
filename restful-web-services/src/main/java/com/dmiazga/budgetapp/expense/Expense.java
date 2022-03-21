package com.dmiazga.budgetapp.expense;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Expense {
	@Id
	@GeneratedValue
	private Long expenseid;
	private String username;
	private String description;
	private Date targetDate;
	private Date finishDate;
	private Double price;
	private String categoryname;
	private String comment;
	private String cycle;

	public Expense() {
	}

	public Expense(
			long expenseid, 
			String username, 
			String description, 
			Date targetDate, 
			Date finishDate, 
			double price, 
			String categoryname,
			String comment, 
			String cycle) {
		super();
		this.expenseid = expenseid;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.finishDate = finishDate;
		this.price = price;
		this.categoryname = categoryname;
		this.comment = comment;
		this.cycle = cycle;
	}

	public Long getId() {
		return expenseid;
	}

	public void setId(Long expenseid) {
		this.expenseid = expenseid;
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
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return categoryname;
	}

	public void setCategory(String categoryname) {
		this.categoryname = categoryname;
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
		result = prime * result + (int) (expenseid ^ (expenseid >>> 32));
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
		Expense other = (Expense) obj;
		if (expenseid != other.expenseid)
			return false;
		return true;
	}
}