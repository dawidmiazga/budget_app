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
	private Long usernameid;
	private String description;
	private Date target_date;
	private Date finish_date;
	private Double price;
	private Long categoryid;
	private String comment;
	private String cycle;
	private String bankaccountname;

	public Expense() {
	}

	public Expense(long expenseid, long usernameid, String description, Date target_date, Date finish_date,
			double price, long categoryid, String comment, String cycle, String bankaccountname) {
		super();
		this.expenseid = expenseid;
		this.usernameid = usernameid;
		this.description = description;
		this.target_date = target_date;
		this.finish_date = finish_date;
		this.price = price;
		this.categoryid = categoryid;
		this.comment = comment;
		this.cycle = cycle;
		this.bankaccountname = bankaccountname;
	}

	public Long getExpenseid() {
		return expenseid;
	}

	public void setExpenseid(Long expenseid) {
		this.expenseid = expenseid;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
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
		return expenseid;
	}

	public void setId(Long expenseid) {
		this.expenseid = expenseid;
	}

	public Long getCategory() {
		return categoryid;
	}

	public void setCategory(Long categoryid) {
		this.categoryid = categoryid;
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

	public String getBankaccountname() {
		return bankaccountname;
	}

	public void setBankaccountname(String bankaccountname) {
		this.bankaccountname = bankaccountname;
	}
}